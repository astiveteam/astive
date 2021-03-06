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


public class HangupAction extends ActionMessage {
  private String channel;
  private int cause;

  /**
   * Creates a new HangupAction object.
   *
   * @param channel DOCUMENT ME!
   */
  public HangupAction(String channel) {
    super(ActionType.HANGUP);
    this.channel = channel;
  }

  /**
   * Creates a new HangupAction object.
   *
   * @param channel DOCUMENT ME!
   * @param cause DOCUMENT ME!
   */
  public HangupAction(String channel, int cause) {
    super(ActionType.HANGUP);
    this.channel = channel;
    this.cause = cause;
  }

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public int getCause() {
    return cause;
  }

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public String getChannel() {
    return channel;
  }

  /**
   * DOCUMENT ME!
   *
   * @param cause DOCUMENT ME!
   */
  public void setCause(int cause) {
    this.cause = cause;
  }

  /**
   * DOCUMENT ME!
   *
   * @param channel DOCUMENT ME!
   */
  public void setChannel(String channel) {
    this.channel = channel;
  }
}
