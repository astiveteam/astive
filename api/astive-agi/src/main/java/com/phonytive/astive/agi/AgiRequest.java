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
package com.phonytive.astive.agi;

import com.phonytive.astive.agi.annotation.RequestField;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.log4j.Logger;

/**
 * Contain information about the channel the script is invoked on.
 * This is the first package sent by a <code>channel</code> in AGI protocol.
 *
 * @since 1.0.0
 */
public class AgiRequest {
    /**
     * Serial version identifier.
     */
    private static final long serialVersionUID = -6279678160047296949L;
    // A usual logging class
    private static final Logger logger = Logger.getLogger(AgiRequest.class);    
    
    private static Map<String, String> parameters;
            
    /**
     * Collection of a pair key/value element with information about
     * the <code>channel</code>.
     */
    private ArrayList<String> lines;
    /**
     * Account code (if specified).
     */
    @RequestField("agi_accountcode")
    private String accountCode;
    /**
     * Caller Id Number only(e.g. "123").
     */
    @RequestField("agi_callerid")
    private String callerId;
    /**
     * Caller Id Name only(e.g. "John Doe")
     */
    @RequestField("agi_calleridname")
    private String callerIdName;
    /**
     * ANI2 (Info digits) also called Originating line information or OLI.
     * Possible codes are listed can be founded at:
     *
     * <br>http://www.nanpa.com/number_resource_info/ani_ii_assignments.html
     */
    @RequestField("agi_callingani2")
    private Integer callingAni2;
    /**
     * Caller ID presentation for incoming calls (PRI channels).
     * Class {@link PresentationType} can be use to decode this value.
     */
    @RequestField("agi_callingpres")
    private Integer callingPres;
    /**
     * Transit Network Selector (PRI channels).
     * Note: Will be a great contribution if you send us a link or document
     * with an in deep explanation about this parameter.
     */
    @RequestField("agi_callingtns")
    private Integer callingTns;
    /**
     * Caller Type of Number (PRI channels).
     * Class {@link TonType} can be use to decode this value.
     */
    @RequestField("agi_callington")
    private Integer callingTon;
    /**
     * Current channel name.
     */
    @RequestField("agi_channel")
    private String channel;
    /**
     * Current context.
     */
    @RequestField("agi_context")
    private String context;
    /**
     * Dialed Number Identifier.
     */
    @RequestField("agi_dnid")
    private String dnId;
    /**
     * Whether this Agi is passed audio (EAGI - Enhanced AGI).
     */
    @RequestField("agi_enhanced")
    private Boolean enhanced;
    /**
     * Extension that was called (e.g. 300).
     */
    @RequestField("agi_extension")
    private String extension;
    /**
     * Current language. Language for the current <code>channel</code>.
     */
    @RequestField("agi_language")
    private String language;
    /**
     * Whether or not this lines was sent throw a network(fastagi).
     */
    @RequestField("agi_network")
    private Boolean network;
    /**
     * Remote Agi script(fastagi script).
     */
    @RequestField("agi_network_script")
    private String script;
    /**
     * Current priority in the dialplan.
     */
    @RequestField("agi_priority")
    private String priority;
    /**
     * Redirected Dial Number ID Service.
     */
    @RequestField("agi_rdnis")
    private String rdNis;
    /**
     * Name of the Agi script that is being called.
     */
    @RequestField("agi_request")
    private String requestURL;
    /**
     *
     */
    @RequestField("agi_threadid")
    private String threadId;
    /**
     * Channel type(e.g. ZAP, SIP, H323, IAX...).
     */
    @RequestField("agi_type")
    private ChannelType channelType;
    /**
     * Current call unique identifier
     */
    @RequestField("agi_uniqueid")
    private String callId;
    /**
     * Version of the AGI version(Asterisk Version).
     */
    @RequestField("agi_version")
    private String version; // TODO: Investigate, how to get asterisk version...
    /**
     * Use to map Agi field with AgiRequest variables.
     */
    private HashMap<String, String> fieldsMap;

    /**
     * Create a new AgiRequest object with the info sent by a new
     * <code>channel</code>.
     *
     * @param lines array of a pairs key/value elements with information about
     * the <code>channel</code>.
     */
    public AgiRequest(final ArrayList<String> lines) {
        this.lines = lines;

        fieldsMap = new HashMap();

        for (String line : lines) {
            if (line.split(":").length < 2) {
                continue;
            }
            // WARNING: Ensure it work for the parameter agi_request
            String key = line.split(":")[0].trim();
            String value = line.split(":")[1].trim();
            if(key.equals("agi_request") && line.split(":").length == 3) {
                value =  value + ":" + line.split(":")[2].trim();
            }
            fieldsMap.put(key, value);
        }

        try {
            fillFields();                                    
        } catch (IllegalArgumentException ex) {
            logger.warn(ex.getMessage());
        } catch (IllegalAccessException ex) {
            logger.warn(ex.getMessage());
        }
        
        // Get parameters.
        // Note: The URL needs to be validated prior to do the next process.
        // TODO: Improve this by using regex        
        parameters = new HashMap<String, String>();
        
        String params = null;
        
        if(script.split("\\?").length > 1) {
            params = script.split("\\?")[1];
        }
        
        String and = null;
        
        if(params != null) {
            if(params.split("&").length > 1) {
                String[] p = params.split("&");
                for(String s: p) {
                    String key = s.split("=")[0].trim();
                    String val = s.split("=")[1].trim();
                    parameters.put(key, val);
                }
            }
        }
    }

    /**
     * Set a variables by using reflection.
     */
    private void fillFields()
            throws IllegalArgumentException, IllegalAccessException {
        for (String af : fieldsMap.keySet()) {
            for (Field f : AgiRequest.class.getDeclaredFields()) {
                RequestField rf;

                if (f.isAnnotationPresent(RequestField.class)) {
                    rf = f.getAnnotation(RequestField.class);
                } else {
                    continue;
                }

                if (rf.value().equals(af)) {
                    // There is an exeption for the variables:
                    // channelType, enhanced and network
                    if (f.getName().equals("network")) {
                        if (fieldsMap.get(af).equals("yes")) {
                            f.set(this, Boolean.TRUE);
                        } else {
                            f.set(this, Boolean.FALSE);
                        }

                        break;
                    } else if (f.getName().equals("enhanced")) {
                        if (fieldsMap.get(af).equals("1.0")) {
                            f.set(this, Boolean.TRUE);
                        } else {
                            f.set(this, Boolean.FALSE);
                        }

                        break;
                    } else if (f.getType().equals(ChannelType.class)) {
                        f.set(this, ChannelType.get(fieldsMap.get(af)));

                        break;
                    } else if (f.getType().equals(Integer.class)) {
                        f.set(this, new Integer(fieldsMap.get(af)));

                        break;
                    } else {
                        f.set(this, fieldsMap.get(af));

                        break;
                    }
                }
            }
        }
    }

    /**
     * Get a list with the requestURL parameters.
     */
    public ArrayList<String> getLines() {
        return lines;
    }

    /**
     * Return all elements key/value of this lines.
     *
     * @return all elements key/value of this lines.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("agi_network:");

        if (isNetwork()) {
            sb.append("yes");
        } else {
            sb.append("no");
        }

        sb.append("\n");

        sb.append("agi_network_script:");
        sb.append(getRequestURL());
        sb.append("\n");

        sb.append("agi_request:");
        sb.append(getScript());
        sb.append("\n");

        sb.append("agi_channel:");
        sb.append(getChannel());
        sb.append("\n");

        sb.append("agi_language:");
        sb.append(getLanguage());
        sb.append("\n");

        sb.append("agi_type:");
        sb.append(getChannelType());
        sb.append("\n");

        sb.append("agi_uniqueid:");
        sb.append(getCallId());
        sb.append("\n");

        sb.append("agi_version:");
        sb.append(getVersion());
        sb.append("\n");

        sb.append("agi_callerid:");
        sb.append(getCallerId());
        sb.append("\n");

        sb.append("agi_calleridname:");
        sb.append(getCallerIdName());
        sb.append("\n");

        sb.append("agi_callingpres:");
        sb.append(getCallingPres());
        sb.append("\n");

        sb.append("agi_callingani2:");
        sb.append(getCallingAni2());
        sb.append("\n");

        sb.append("agi_callingtns:");
        sb.append(getCallingTns());
        sb.append("\n");

        sb.append("agi_dnid:");
        sb.append(getDnId());
        sb.append("\n");

        sb.append("agi_rdnis:");
        sb.append(getRdNis());
        sb.append("\n");

        sb.append("agi_context:");
        sb.append(getContext());
        sb.append("\n");

        sb.append("agi_extension:");
        sb.append(getExtension());
        sb.append("\n");

        sb.append("agi_priority:");
        sb.append(getPriority());
        sb.append("\n");

        sb.append("agi_enhanced:");
        sb.append(isEnhanced());
        sb.append("\n");

        sb.append("agi_accountcode:");
        sb.append(getAccountCode());
        sb.append("\n");

        sb.append("agi_threadid:");
        sb.append(getThreadId());

        return sb.toString();
    }

    public String getAccountCode() {
        return accountCode;
    }

    public String getCallerId() {
        return callerId;
    }

    public String getCallerIdName() {
        return callerIdName;
    }

    public Integer getCallingAni2() {
        return callingAni2;
    }

    public Integer getCallingPres() {
        return callingPres;
    }

    public Integer getCallingTns() {
        return callingTns;
    }

    public Integer getCallingTon() {
        return callingTon;
    }

    public String getChannel() {
        return channel;
    }

    public String getContext() {
        return context;
    }

    public String getDnId() {
        return dnId;
    }

    public Boolean isEnhanced() {
        return enhanced;
    }

    public String getExtension() {
        return extension;
    }

    public String getLanguage() {
        return language;
    }

    public Boolean isNetwork() {
        return network;
    }

    public String getScript() {
        return script;
    }

    public String getPriority() {
        return priority;
    }

    public String getRdNis() {
        return rdNis;
    }

    public String getRequestURL() {
        return requestURL;
    }

    public String getThreadId() {
        return threadId;
    }

    public ChannelType getChannelType() {
        return channelType;
    }

    public String getCallId() {
        return callId;
    }

    public String getVersion() {
        return version;
    }
    
    public String getParameter(String parameter) {
        return parameters.get(parameter);
    }
}
