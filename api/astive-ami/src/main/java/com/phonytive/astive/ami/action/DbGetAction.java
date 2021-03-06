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
public class DbGetAction extends ActionMessage {
  private String family;
  private String key;

  /**
   * Creates a new DbGetAction object.
   *
   * @param family DOCUMENT ME!
   * @param key DOCUMENT ME!
   */
  public DbGetAction(String family, String key) {
    super(ActionType.DB_GET);
    this.family = family;
    this.key = key;
  }

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public String getFamily() {
    return family;
  }

  /**
   * DOCUMENT ME!
   *
   * @return DOCUMENT ME!
   */
  public String getKey() {
    return key;
  }

  /**
   * DOCUMENT ME!
   *
   * @param family DOCUMENT ME!
   */
  public void setFamily(String family) {
    this.family = family;
  }

  /**
   * DOCUMENT ME!
   *
   * @param key DOCUMENT ME!
   */
  public void setKey(String key) {
    this.key = key;
  }
}
