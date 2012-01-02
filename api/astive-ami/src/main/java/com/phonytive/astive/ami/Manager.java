// Astive, is the core library of Astive Toolkit, the framework for
// developers wishing to create concise and easy to maintain applications
// for Asterisk® PBX, even for complex navigation.
//
// Copyright (C) 2010-2011 PhonyTive, S.L.
// http://www.phonytive.com/astive
//
// This file is part of Astive
//
// Astive is free software: you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// Astive is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU General Public License for more details.
//
// You should have received a copy of the GNU General Public License
// along with Astive.  If not, see <http://www.gnu.org/licenses/>.
package com.phonytive.astive.ami;

import com.phonytive.astive.ami.action.ActionMessage;
import com.phonytive.astive.ami.action.ResponseMessage;
import com.phonytive.astive.ami.event.ManagerEvent;

import java.util.ArrayList;


/**
 *
 * @author Pedro Sanders <psanders@kaffeineminds.com>
 * @since 0.1
 * @version $Id$
 */
public abstract class Manager {
    public static int DEFAULT_PORT = 5038;
    private ArrayList<ManagerEventListener> managerEventListenerList = new ArrayList();

    abstract void login() throws AmiException;

    abstract void logout() throws AmiException;

    abstract ResponseMessage sendAction(ActionMessage action)
        throws AmiException;

    abstract String getVersion();

    public void addManagerEventListener(ManagerEventListener listener) {
        managerEventListenerList.add(listener);
    }

    public void removeManagerEventListener(ManagerEventListener listener) {
        managerEventListenerList.remove(listener);
    }

    protected void fireEvent(ManagerEvent evt) {
        for (ManagerEventListener listener : managerEventListenerList) {
            listener.handleEvent(evt);
        }
    }
}