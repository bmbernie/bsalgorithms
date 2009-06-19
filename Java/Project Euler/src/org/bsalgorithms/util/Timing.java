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
 * Very simple timer for code generation time statistics.
 *
 * Not very exact, measures user time, not processor time.
 *
 * @author Gerwin Klein
 * @version JFlex 1.4.1, $Revision: 2.3 $, $Date: 2004/11/06 23:03:32 $
 */
public class Timing {

  /* the timer stores start and stop time from currentTimeMillis() */
  private long startTime, stopTime; 

  /**
   * Construct a new timer
   */
  public Timing() {
  }

  
  /**
   * Start the timer.
   */
  public void start() {
    startTime = System.nanoTime();
  }


  /**
   * Stop the timer.
   */
  public void stop() {
    stopTime = System.nanoTime();
  }

  
  /**
   * Return the number of milliseconds the timer has been running.
   *
   */
  public long diff() {
      return stopTime-startTime;    
  }

  
  /**
   * Return a string representation of the timer.
   *
   * @return a string displaying the diff-time in ms
   */
  public String toString() {
    return ((diff() / 1000000) + " ms");
  }
}

