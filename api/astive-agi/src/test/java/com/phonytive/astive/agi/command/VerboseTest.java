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

import com.phonytive.astive.agi.AgiException;
import com.phonytive.astive.agi.command.Verbose;
import com.phonytive.astive.agi.CommandProcessor;

import junit.framework.TestCase;


public class VerboseTest extends TestCase {
    public VerboseTest(String testName) {
        super(testName);
    }

    public void testCommand() throws AgiException {
        String message = "This is a message";
        Integer level = 2;

        StringBuilder b = new StringBuilder("VERBOSE");
        b.append(" ");
        b.append("\"");
        b.append(message);
        b.append("\"");
        b.append(" ");
        b.append(level);

        Verbose command = new Verbose(message, level);
        assert (b.toString().equals(CommandProcessor.buildCommand(command)));
    }
}
