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
package com.phonytive.astive.agitdd;

import com.phonytive.astive.agi.AgiException;
import com.phonytive.astive.agi.ChannelStatus;
import com.phonytive.astive.astivlet.Astivlet;
import com.phonytive.astive.astivlet.AstivletRequest;
import com.phonytive.astive.astivlet.AstivletResponse;
import static java.lang.System.out;

/**
 * Agi QA test.
 * 
 * @since 1.0.0
 */
public class App extends Astivlet {

    @Override
    public void service(AstivletRequest request, AstivletResponse response) {
        try {
            response.answer();
            response.streamFile("tt-monkeys");            
            response.controlStreamFile("tt-monkeys");                                    
            
            char digit = response.controlStreamFile("tt-monkeys", "1234567890#*");
            out.println("Digit pressed -> " + digit);
            
            digit = response.controlStreamFile("tt-monkeys", "#*", 1000);
            out.println("Digit pressed -> " + digit);
            
            digit = response.controlStreamFile("tt-monkeys", "123456789", 1000, '*', '#', '0');
            out.println("Digit pressed -> " + digit);
            
            ChannelStatus status = response.getChannelStatus();
            out.println("Channel status -> " + status);
            
            String digits = response.getData("tt-monkeys");
            out.println("Digits -> " + digits);
            
            digits = response.getData("tt-monkeys", 5);
            out.println("Digits -> " + digits);
            
            response.hangup();
        } catch (AgiException ex) {
            out.println(ex.getMessage());
        }
    }
}
