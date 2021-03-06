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
package com.phonytive.astive.agi.command;

import com.phonytive.astive.agi.annotation.AgiCommand;
import com.phonytive.astive.agi.annotation.BooleanChoose;
import com.phonytive.astive.agi.annotation.ParamConverter;
import com.phonytive.astive.agi.annotation.Parameter;

import java.io.Serializable;


/**
 * Enable/Disable TDD transmission/reception on a channel. 
 * 
 * <p>Returns 1 if successful, or 0 if channel is not TDD-capable.
 *
 * @since 1.0.0
 */
@AgiCommand(command = "TDD MODE")
public class TddMode implements Serializable {
    /**
     * Serial version identifier.
     */
    private static final long serialVersionUID = 5179054735596539116L;
    
    /**
     * Enable/Disable TDD transmission/reception on a channel.
     */
    @Parameter(optional = false)
    @ParamConverter
    @BooleanChoose
    private Boolean enable;

    /**
     * Create a new TddMode object.
     * 
     * @param enable enable/disable TDD transmission/reception on a channel. 
     * <code>true</code> to enable or <code>false</code> to disable TDD mode.
     */
    public TddMode(Boolean enable) {
        this.enable = enable;
    }

    /**
     * Whether or not TDD mode is enable.
     * 
     * @return <code>true</code> to enable or <code>false</code> to disable 
     * TDD mode.
     */
    public Boolean isEnable() {
        return enable;
    }

    /**
     * Enable/Disable TDD mode.
     * 
     * @param enable set enable to <code>true</code> to enable or <code>false</code> 
     * to disable TDD mode.
     */
    public void setEnable(Boolean enable) {
        this.enable = enable;
    }
}
