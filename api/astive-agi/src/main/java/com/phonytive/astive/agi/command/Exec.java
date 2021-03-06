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
import com.phonytive.astive.agi.annotation.ParamConverter;
import com.phonytive.astive.agi.annotation.Parameter;
import com.phonytive.astive.agi.annotation.Separator;

import java.io.Serializable;


/**
 * Executes <code>application</code> with given <code>options</code>.
 *
 * <p>Returns whatever the application returns, or -2 on failure to find
 * application.

 * @since 1.0.0
 */
@AgiCommand(command = "EXEC")
public class Exec implements Serializable {
    /**
     * Serial version identifier.
     */
    private static final long serialVersionUID = -6489004022425967088L;

    /**
     * Application to execute.
     */
    @Parameter(optional = false)
    private String application;

    /**
     * Application options.
     */
    @Parameter(position = 1)
    @ParamConverter
    @Separator
    private String[] options;

    /**
     * Create a new Exec object.
     *
     * @param application application to execute.
     */
    public Exec(String application) {
        this.application = application;
    }

    /**
     * Create a new Exec object with options.
     *
     * @param application application to execute.
     * @param options application options.
     */
    public Exec(String application, String... options) {
        this.application = application;
        this.options = options;
    }

    /**
     * Get application to execute.
     *
     * @return application to execute.
     */
    public String getApplication() {
        return application;
    }

    /**
     * Set application to execute.
     *
     * @param application application to execute.
     */
    public void setApplication(String application) {
        this.application = application;
    }

    /**
     * Get application options.
     *
     * @return application options.
     */
    public String[] getOptions() {
        return options;
    }

    /**
     * Set application options.
     *
     * @param options applications options
     */
    public void setOptions(String... options) {
        this.options = options;
    }
}
