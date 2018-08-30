/*
 * Copyright 2018 Stella Filippo.
 *
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
 */
package Model;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author Stella Filippo
 */
public class Timer extends Thread {
    
    private Integer StartTime;
    private final JLabel timer;

    public Timer(Long millis, JLabel timer) {
        this.timer = timer;
        this.StartTime = new Long(TimeUnit.MILLISECONDS.toMinutes(millis)).intValue();
        this.timer.setText(this.StartTime.toString());
    }

    @Override
    public void run() {
        try {
            sleep(1000);
            this.StartTime-=1;
        } catch (InterruptedException ex) {
            Logger.getLogger(Timer.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.timer.setText(this.StartTime.toString());
        }
        
    }  
}
