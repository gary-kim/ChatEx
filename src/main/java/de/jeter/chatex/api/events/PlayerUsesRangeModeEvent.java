/*
 * This file is part of ChatEx
 * Copyright (C) 2020 ChatEx Team
 * 
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301, USA.
 */
package de.jeter.chatex.api.events;

import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;

public class PlayerUsesRangeModeEvent extends ChatExEvent {
    
    private static final HandlerList handlers = new HandlerList();
    private String message;
    private final Player player;
    private boolean canceled = false;

    public PlayerUsesRangeModeEvent(Player player, String message){
        this.player = player;
        this.message = message;
    }

    /**
     * @return the player which fired this event
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * @return the message which the player would have written.
     */
    public String getMessage() {
        return message;
    }

    /**
     *
     * @param message set the message which the player writes.
     */
    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    @Override
    public boolean isCancelled() {
        return canceled;
    }

    @Override
    public void setCancelled(boolean b) {
        canceled = b;
    }
}
