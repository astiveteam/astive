/* 
 * Copyright (C) 2010-2012 PhonyTive LLC
 * http://astive.phonytive.com
 *
 * This file is part of Astive Toolkit
 *
 * Astive is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Astive is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Astive.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.phonytive.astive.ami.action;


/**
 *
 * @since 1.0.0
 */
public class QueuePenaltyAction extends ActionMessage {
  private String iface;
  private String queue;
  private int penalty;

  /**
   * Creates a new QueuePenaltyAction object.
   *
   * @param iface DOCUMENT ME!
   * @param penalty DOCUMENT ME!
   */
  public QueuePenaltyAction(String iface, int penalty) {
    super(ActionType.QUEUE_PENALTY);
    this.iface = iface;
    this.penalty = penalty;
  }

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public String getInterface() {
    return iface;
  }

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public int getPenalty() {
    return penalty;
  }

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public String getQueue() {
    return queue;
  }

  /**
   * DOCUMENT ME!
   *
   * @param iface DOCUMENT ME!
   */
  public void setInterface(String iface) {
    this.iface = iface;
  }

  /**
   * DOCUMENT ME!
   *
   * @param penalty DOCUMENT ME!
   */
  public void setPenalty(int penalty) {
    this.penalty = penalty;
  }

  /**
   * DOCUMENT ME!
   *
   * @param queue DOCUMENT ME!
   */
  public void setQueue(String queue) {
    this.queue = queue;
  }
}
