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
import com.phonytive.astive.agi.command.SayTime;
import com.phonytive.astive.agi.CommandProcessor;

import junit.framework.TestCase;

import java.util.Date;


public class SayTimeTest extends TestCase {
    public SayTimeTest(String testName) {
        super(testName);
    }

    public void testCommand() throws AgiException {
        Date date = new Date();
        long seconds = (date).getTime() / 1000;
        String escapeDigits = "";

        // Testing first constructor
        StringBuilder b = new StringBuilder("SAY TIME");
        b.append(" ");
        b.append("\"");
        b.append(seconds);
        b.append("\"");
        b.append(" ");
        b.append("\"");
        b.append(escapeDigits);
        b.append("\"");

        SayTime command = new SayTime(date);
        assert (b.toString().equals(CommandProcessor.buildCommand(command)));

        // Testing second constructor
        escapeDigits = "123";
        b = new StringBuilder("SAY TIME");
        b.append(" ");
        b.append("\"");
        b.append(seconds);
        b.append("\"");
        b.append(" ");
        b.append("\"");
        b.append(escapeDigits);
        b.append("\"");

        command = new SayTime(date, escapeDigits);
        assert (b.toString().equals(CommandProcessor.buildCommand(command)));
    }
}
