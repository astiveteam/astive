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
public class DahdiDialOffHookAction extends ActionMessage {
  private String dahdiChannel;
  private String number;

  /**
   * Creates a new DahdiDialOffHookAction object.
   *
   * @param dahdiChannel DOCUMENT ME!
   * @param number DOCUMENT ME!
   */
  public DahdiDialOffHookAction(String dahdiChannel, String number) {
    super(ActionType.DAHDI_DIAL_OFF_HOOK);
    this.dahdiChannel = dahdiChannel;
    this.number = number;
  }

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public String getDahdiChannel() {
    return dahdiChannel;
  }

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public String getNumber() {
    return number;
  }

  /**
   * DOCUMENT ME!
   *
   * @param dahdiChannel DOCUMENT ME!
   */
  public void setDahdiChannel(String dahdiChannel) {
    this.dahdiChannel = dahdiChannel;
  }

  /**
   * DOCUMENT ME!
   *
   * @param number DOCUMENT ME!
   */
  public void setNumber(String number) {
    this.number = number;
  }
}
