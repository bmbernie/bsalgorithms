/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * bsalgorithms 0.9.9                                                      *
 * Copyright (C) 2008-2009  Brandon Bernie <bmbernie@gmail.com>             *
 * All rights reserved.                                                    *
 *                                                                         *
 * This program is free software; you can redistribute it and/or modify    *
 * it under the terms of the GNU General Public License. See the file      *
 * COPYRIGHT for more information.                                         *
 *                                                                         *
 * This program is distributed in the hope that it will be useful,         *
 * but WITHOUT ANY WARRANTY; without even the implied warranty of          *
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the           *
 * GNU General Public License for more details.                            *
 *                                                                         *
 * You should have received a copy of the GNU General Public License along *
 * with this program; if not, write to the Free Software Foundation, Inc., *
 * 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA                 *
 *                                                                         *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

package org.bsalgorithms.util;

/**
 * <p>
 * <code>HiResStopWatch</code> provides a convenient API for high resolution
 * timings.
 * </p>
 * 
 * <p>
 * To start the watch, call {@link #start()}. At this point you can:
 * </p>
 * <ul>
 * <li>{@link #split()} the watch to get the time whilst the watch continues in
 * the background. {@link #unsplit()} will remove the effect of the split. At
 * this point, these three options are available again.</li>
 * <li>{@link #suspend()} the watch to pause it. {@link #resume()} allows the
 * watch to continue. Any time between the suspend and resume will not be
 * counted in the total. At this point, these three options are available again.
 * </li>
 * <li>{@link #stop()} the watch to complete the timing session.</li>
 * </ul>
 * 
 * <p>
 * It is intended that the output methods {@link #toString()} and
 * {@link #getTime()} should only be called after stop, split or suspend,
 * however a suitable result will be returned at other points.
 * </p>
 * 
 * <p>
 * 1. split(), suspend(), or stop() cannot be invoked twice<br />
 * 2. unsplit() may only be called if the watch has been split()<br />
 * 3. resume() may only be called if the watch has been suspend()<br />
 * 4. start() cannot be called twice without calling reset()
 * </p>
 * 
 * @author Brandon Bernie
 * @version $Id: HiResStopWatch.java 5135648 2009-06-19T06:56Z bmbernie $
 */
public class HiResStopWatch {
	
	// running states
	private static final int STATE_UNSTARTED = 0;
	private static final int STATE_RUNNING = 1;
	private static final int STATE_STOPPED = 2;
	private static final int STATE_SUSPENDED = 3;

	// split state
	private static final int STATE_UNSPLIT = 10;
	private static final int STATE_SPLIT = 11;

	/**
	 * The current running state of the StopWatch.
	 */
	private int runningState = STATE_UNSTARTED;

	/**
	 * Whether the stopwatch has a split time recorded.
	 */
	private int splitState = STATE_UNSPLIT;

	/**
	 * The start time.
	 */
	private long startTime = -1;

	/**
	 * The stop time.
	 */
	private long stopTime = -1;

	/**
	 * <p>
	 * Constructor.
	 * </p>
	 */
	public HiResStopWatch() {
		super();
	}

	/**
	 * <p>
	 * Start the high resolution stopwatch.
	 * </p>
	 * 
	 * <p>
	 * This method starts a new timing session, clearing any previous values.
	 * </p>
	 * 
	 * @throws IllegalStateException
	 *             if the StopWatch is already running.
	 */
	public void start() {
		if (this.runningState == STATE_STOPPED) {
			throw new IllegalStateException(
					"Stopwatch must be reset before being restarted. ");
		}
		if (this.runningState != STATE_UNSTARTED) {
			throw new IllegalStateException("Stopwatch already started. ");
		}
		this.stopTime = -1;
		this.startTime = System.nanoTime();
		this.runningState = STATE_RUNNING;
	}

	/**
	 * <p>
	 * Stop the high resolution stopwatch.
	 * </p>
	 * 
	 * <p>
	 * This method ends a new timing session, allowing the time to be retrieved.
	 * </p>
	 * 
	 * @throws IllegalStateException
	 *             if the StopWatch is not running.
	 */
	public void stop() {
		if (this.runningState != STATE_RUNNING
				&& this.runningState != STATE_SUSPENDED) {
			throw new IllegalStateException("Stopwatch is not running. ");
		}
		if (this.runningState == STATE_RUNNING) {
			this.stopTime = System.nanoTime();
		}
		this.runningState = STATE_STOPPED;
	}

	/**
	 * <p>
	 * Resets the stopwatch. Stops it if need be.
	 * </p>
	 * 
	 * <p>
	 * This method clears the internal values to allow the object to be reused.
	 * </p>
	 */
	public void reset() {
		this.runningState = STATE_UNSTARTED;
		this.splitState = STATE_UNSPLIT;
		this.startTime = -1;
		this.stopTime = -1;
	}

	/**
	 * <p>
	 * Split the time.
	 * </p>
	 * 
	 * <p>
	 * This method sets the stop time of the watch to allow a time to be
	 * extracted. The start time is unaffected, enabling {@link #unsplit()} to
	 * continue the timing from the original start point.
	 * </p>
	 * 
	 * @throws IllegalStateException
	 *             if the StopWatch is not running.
	 */
	public void split() {
		if (this.runningState != STATE_RUNNING) {
			throw new IllegalStateException("Stopwatch is not running. ");
		}
		this.stopTime = System.nanoTime();
		this.splitState = STATE_SPLIT;
	}

	/**
	 * <p>
	 * Remove a split.
	 * </p>
	 * 
	 * <p>
	 * This method clears the stop time. The start time is unaffected, enabling
	 * timing from the original start point to continue.
	 * </p>
	 * 
	 * @throws IllegalStateException
	 *             if the StopWatch has not been split.
	 */
	public void unsplit() {
		if (this.splitState != STATE_SPLIT) {
			throw new IllegalStateException("Stopwatch has not been split. ");
		}
		this.stopTime = -1;
		this.splitState = STATE_UNSPLIT;
	}

	/**
	 * <p>
	 * Suspend the stopwatch for later resumption.
	 * </p>
	 * 
	 * <p>
	 * This method suspends the watch until it is resumed. The watch will not
	 * include time between the suspend and resume calls in the total time.
	 * </p>
	 * 
	 * @throws IllegalStateException
	 *             if the StopWatch is not currently running.
	 */
	public void suspend() {
		if (this.runningState != STATE_RUNNING) {
			throw new IllegalStateException(
					"Stopwatch must be running to suspend. ");
		}
		this.stopTime = System.nanoTime();
		this.runningState = STATE_SUSPENDED;
	}

	/**
	 * <p>
	 * Resume the high resolution stopwatch after a suspend.
	 * </p>
	 * 
	 * <p>
	 * This method resumes the watch after it was suspended. The watch will not
	 * include time between the suspend and resume calls in the total time.
	 * </p>
	 * 
	 * @throws IllegalStateException
	 *             if the StopWatch has not been suspended.
	 */
	public void resume() {
		if (this.runningState != STATE_SUSPENDED) {
			throw new IllegalStateException(
					"Stopwatch must be suspended to resume. ");
		}
		this.startTime += (System.nanoTime() - this.stopTime);
		this.stopTime = -1;
		this.runningState = STATE_RUNNING;
	}

	/**
	 * <p>
	 * Get the time on the high resolution stopwatch.
	 * </p>
	 * 
	 * <p>
	 * This is either the time between the start and the moment this method is
	 * called, or the amount of time between start and stop.
	 * </p>
	 * 
	 * @return the time in nanoseconds
	 */
	public long getTime() {
		if (this.runningState == STATE_STOPPED
				|| this.runningState == STATE_SUSPENDED) {
			return this.stopTime - this.startTime;
		} else if (this.runningState == STATE_UNSTARTED) {
			return 0;
		} else if (this.runningState == STATE_RUNNING) {
			return System.nanoTime() - this.startTime;
		}
		throw new RuntimeException("Illegal running state has occured. ");
	}

	/**
	 * <p>
	 * Get the split time on the stopwatch.
	 * </p>
	 * 
	 * <p>
	 * This is the time between start and latest split.
	 * </p>
	 * 
	 * @return the split time in milliseconds
	 * 
	 * @throws IllegalStateException
	 *             if the StopWatch has not yet been split.
	 * @since 2.1
	 */
	public long getSplitTime() {
		if (this.splitState != STATE_SPLIT) {
			throw new IllegalStateException(
					"Stopwatch must be split to get the split time. ");
		}
		return this.stopTime - this.startTime;
	}

	/**
	 * Returns the time this stopwatch was started.
	 * 
	 * @return the time this stopwatch was started
	 * @throws IllegalStateException
	 *             if this StopWatch has not been started
	 * @since 2.4
	 */
	public long getStartTime() {
		if (this.runningState == STATE_UNSTARTED) {
			throw new IllegalStateException("Stopwatch has not been started");
		}
		return this.startTime;
	}

	/**
	 * <p>
	 * Gets a summary of the time that the stopwatch recorded as a string.
	 * </p>
	 * 
	 * <p>
	 * The format used is ISO8601-like,
	 * <i>hours</i>:<i>minutes</i>:<i>seconds</i>.<i>milliseconds</i>.
	 * </p>
	 * 
	 * @return the time as a String
	 */
	public String toString() { 
		return formatDurationHMSMN(getTime());
	}

	/**
	 * <p>
	 * Gets a summary of the split time that the stopwatch recorded as a string.
	 * </p>
	 * 
	 * <p>
	 * The format used is ISO8601-like,
	 * <i>hours</i>:<i>minutes</i>:<i>seconds</i>.<i>milliseconds</i>.
	 * </p>
	 * 
	 * @return the split time as a String
	 * @since 2.1
	 */
	public String toSplitString() {
		return formatDurationHMSMN(getSplitTime());
	}
	
	public String formatDurationHMSMN(final long elapsed){
		long nanos  = elapsed % 1000000;
		long millis = elapsed / 1000000 % 1000;
		long secs   = elapsed / 1000000000L % 60;
		long mins   = elapsed / 1000000000L / 60;
		long hours  = elapsed / 1000000000L / 60 / 60;
		
		return (hours + ":" + mins + ":" + secs + "." + millis + "." + nanos);
	}

}
