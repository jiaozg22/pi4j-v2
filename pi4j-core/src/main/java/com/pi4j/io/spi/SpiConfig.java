package com.pi4j.io.spi;

/*-
 * #%L
 * **********************************************************************
 * ORGANIZATION  :  Pi4J
 * PROJECT       :  Pi4J :: LIBRARY  :: Java Library (CORE)
 * FILENAME      :  SpiConfig.java
 *
 * This file is part of the Pi4J project. More information about
 * this project can be found here:  https://pi4j.com/
 * **********************************************************************
 * %%
 * Copyright (C) 2012 - 2021 Pi4J
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

import com.pi4j.config.AddressConfig;
import com.pi4j.context.Context;
import com.pi4j.io.IOConfig;

/**
 * <p>SpiConfig interface.</p>
 *
 * @author Robert Savage (<a href="http://www.savagehomeautomation.com">http://www.savagehomeautomation.com</a>)
 * @version $Id: $Id
 */
public interface SpiConfig extends AddressConfig<SpiConfig>, IOConfig<SpiConfig> {
    /** Constant <code>BAUD_KEY="baud"</code> */
    String BAUD_KEY = "baud";
    /** Constant <code>MODE_KEY="mode"</code> */
    String MODE_KEY = "mode";

    /**
     * <p>newBuilder.</p>
     *
     * @param context {@link Context}
     * @return a {@link com.pi4j.io.i2c.I2CConfigBuilder} object.
     */
    static SpiConfigBuilder newBuilder(Context context)  {
        return SpiConfigBuilder.newInstance(context);
    }

    /**
     * <p>baud.</p>
     *
     * @return a {@link java.lang.Integer} object.
     */
    Integer baud();
    /**
     * <p>getBaud.</p>
     *
     * @return a {@link java.lang.Integer} object.
     */
    default Integer getBaud() { return baud(); }

    /**
     * <p>mode.</p>
     *
     * @return a {@link com.pi4j.io.spi.SpiMode} object.
     */
    SpiMode mode();
    /**
     * <p>getMode.</p>
     *
     * @return a {@link com.pi4j.io.spi.SpiMode} object.
     */
    default SpiMode getMode() {
        return mode();
    }

}
