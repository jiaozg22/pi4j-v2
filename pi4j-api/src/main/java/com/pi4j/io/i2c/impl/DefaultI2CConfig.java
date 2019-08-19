package com.pi4j.io.i2c.impl;

/*-
 * #%L
 * **********************************************************************
 * ORGANIZATION  :  Pi4J
 * PROJECT       :  Pi4J :: LIBRARY  :: Java Library (API)
 * FILENAME      :  DefaultI2CConfig.java
 *
 * This file is part of the Pi4J project. More information about
 * this project can be found here:  https://pi4j.com/
 * **********************************************************************
 * %%
 * Copyright (C) 2012 - 2019 Pi4J
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import com.pi4j.config.ConfigBase;
import com.pi4j.config.exception.ConfigMissingRequiredKeyException;
import com.pi4j.io.gpio.digital.PullResistance;
import com.pi4j.io.i2c.I2CConfig;
import com.pi4j.util.StringUtil;

import java.util.Map;

public class DefaultI2CConfig
        extends ConfigBase<I2CConfig>
        implements I2CConfig {

    // private configuration properties
    protected Integer bus = null;
    protected Integer device = null;

    /**
     * PRIVATE CONSTRUCTOR
     */
    private DefaultI2CConfig(){
        super();
    }

    // private configuration properties
    protected PullResistance pullResistance = PullResistance.OFF;

    /**
     * PRIVATE CONSTRUCTOR
     * @param properties
     */
    protected DefaultI2CConfig(Map<String,String> properties){
        super(properties);

        // define default property values if any are missing (based on the required address value)
        this.id = StringUtil.setIfNullOrEmpty(this.id, "I2C-" + this.bus() + "." + this.device(), true);
        this.name = StringUtil.setIfNullOrEmpty(this.name, "I2C-" + this.bus() + "." + this.device(), true);
        this.description = StringUtil.setIfNullOrEmpty(this.description, "I2C-" + this.bus() + "." + this.device(), true);

        // load (required) BUS property
        if(properties.containsKey(BUS_KEY)){
            this.bus = Integer.parseInt(properties.get(BUS_KEY));
        } else {
            throw new ConfigMissingRequiredKeyException(BUS_KEY);
        }

        // load (required) DEVICE property
        if(properties.containsKey(DEVICE_KEY)){
            this.device = Integer.parseInt(properties.get(DEVICE_KEY));
        } else {
            throw new ConfigMissingRequiredKeyException(DEVICE_KEY);
        }
    }

    @Override
    public Integer bus() {
        return this.bus;
    }

    @Override
    public Integer device() {
        return this.device;
    }
}
