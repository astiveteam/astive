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
import com.phonytive.astive.agi.annotation.Parameter;

import java.io.Serializable;


/**
 * Send the given file, allowing playback to be controlled by the given digits,
 * if any.
 *
 * <p>Returns '0' if playback completes without a digit being pressed, or the ASCII
 * numerical value of the digit if one was pressed, or '-1' on error or if the
 * <code>channel</code> was disconnected.
 *
 * @since 1.0.0
 * @see StreamFile
 */
@AgiCommand(command = "CONTROL STREAM FILE")
public class ControlStreamFile implements Serializable {
    /**
     * Serial version identifier.
     */
    private static final long serialVersionUID = 3190091457969146433L;

    /**
     * Audio to send to channel.
     */
    @Parameter(optional = false)
    private String file;

    /**
     * Can be use to the interrupt the audio on a channel.
     */
    @Parameter(position = 1, optional = false)
    private String escapeDigits;

    /**
     * Silence time in milliseconds after audio finished. The default value
     * is '0' (no silence).
     */
    @Parameter(position = 2, optional = false)
    private Integer offset;

    /**
     * Digit used to move audio forward.
     */
    @Parameter(position = 3)
    private char forwardDigit;

    /**
     * Digit used to rewind audio.
     */
    @Parameter(position = 4)
    private char rewindDigit;

    /**
     * Digit used to pause audio.
     */
    @Parameter(position = 5)
    private char pauseDigit;

    /**
     * Create a new ControlStreamFile object for a file. Audio can not be
     * interrupted when use this constructor.
     *
     * @param file audio to play.
     */
    public ControlStreamFile(String file) {
        this.file = file;
        escapeDigits = "";
        offset = 0;
    }

    /**
     * Create a new ControlStreamFile object that can interrupt the audio by press
     * a digit present in escapeDigits param.
     *
     * @param file audio to play.
     * @param escapeDigits digits to interrupt the audio.
     */
    public ControlStreamFile(String file, String escapeDigits) {
        this.file = file;
        this.escapeDigits = escapeDigits;
        offset = 0;
    }

    /**
     * Create a new ControlStreamFile object that can interrupt the audio by
     * press a digit present in escapeDigits. The offset(in milliseconds)
     * indicate a silence time after audio finished.
     *
     * @param file audio to play.
     * @param escapeDigits digits to interrupt the audio.
     * @param offset silence time in milliseconds after audio finished.
     */
    public ControlStreamFile(String file, String escapeDigits, Integer offset) {
        this.file = file;
        this.escapeDigits = escapeDigits;
        this.offset = offset;
    }

    /**
     * Create a new ControlStreamFile object that can interrupt. Can interrupt
     * the audio by press a digit present in escapeDigits. The offset(in milliseconds)
     * indicate a silence time after audio finished. Also, digits can be use to
     * control the stream.
     *
     * @param file audio to play.
     * @param escapeDigits digits to interrupt the audio.
     * @param offset silence time in milliseconds after audio finished.
     * @param forwardDigit move audio forward.
     * @param rewindDigit repeat the audio.
     * @param pauseDigit stop the steam.
     */
    public ControlStreamFile(String file, String escapeDigits, Integer offset,
        char forwardDigit, char rewindDigit, char pauseDigit) {
        this.file = file;
        this.escapeDigits = escapeDigits;
        this.offset = offset;
        this.forwardDigit = forwardDigit;
        this.rewindDigit = rewindDigit;
        this.pauseDigit = pauseDigit;
    }

    /**
     * Get audio to be send to <code>channel</code>.
     *
     * @return audio to be send to <code>channel</code>.
     */
    public String getFile() {
        return file;
    }

    /**
     * Set audio to be send to <code>channel</code>. Keep in mind that
     * the audio must not contain any extension.
     *
     * @param file audio to be send to <code>channel</code>
     */
    public void setFile(String file) {
        this.file = file;
    }

    /**
     * Get the digits used to interrupt the audio.
     *
     * @return digits used to interrupt the audio.
     */
    public String getEscapeDigits() {
        return escapeDigits;
    }

    /**
     * Set the digits to be use to interrupt the audio.
     *
     * @param escapeDigits digits to be use to interrupt the audio.
     */
    public void setEscapeDigits(String escapeDigits) {
        this.escapeDigits = escapeDigits;
    }

    /**
     * Get time in milliseconds for silence after audio finished.
     *
     * @return time in milliseconds for silence after audio finished.
     */
    public Integer getOffset() {
        return offset;
    }

    /**
     * Set time in milliseconds for silence after audio finished.
     *
     * @param offset time in milliseconds after audio finished. If this is set null
     * any subsequent parameter will be ignore.
     */
    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    /**
     * Get the digit that move audio forward.
     *
     * @return digit that move audio forward or null if none is provided.
     */
    public char getForwardDigit() {
        return forwardDigit;
    }

    /**
     * Set the digit that move audio forward.
     *
     * @param forwardDigit digit that move audio forward. If this is set null
     * any subsequent parameter will be ignore.
     */
    public void setForwardDigit(char forwardDigit) {
        this.forwardDigit = forwardDigit;
    }

    /**
     * Get the digit to pause audio.
     *
     * @return digit to pause audio.
     */
    public char getPauseDigit() {
        return pauseDigit;
    }

    /**
     * Set the digit to pause audio. If this is set null any subsequent
     * parameter will be ignore.
     *
     * @param pauseDigit digit to pause audio.
     */
    public void setPauseDigit(char pauseDigit) {
        this.pauseDigit = pauseDigit;
    }

    /**
     * Get the digit to pause audio.
     *
     * @return digit to pause audio.
     */
    public char getRewindDigit() {
        return rewindDigit;
    }

    /**
     * Set the digit to rewind audio.
     *
     * @param rewindDigit digit to rewind audio.
     */
    public void setRewindDigit(char rewindDigit) {
        this.rewindDigit = rewindDigit;
    }
}
