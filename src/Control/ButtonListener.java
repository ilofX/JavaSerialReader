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
package Control;

import Model.FileManager;
import Model.SerialReader;
import View.MainFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author Stella Filippo
 * @version 1.0
 */
public class ButtonListener implements ActionListener {

    private final MainFrame mf;
    private final SerialReader sr;
    private final FileManager fm;
    private final ExecutorService executor = Executors.newSingleThreadExecutor();

    public ButtonListener(SerialReader sr, MainFrame mf, FileManager fm) {
        this.mf = mf;
        this.sr = sr;
        this.fm = fm;
        this.mf.addButtonListener(this);
    }
    
    public void Timer(boolean state){
        if(state){
            //this.executor.execute(new Timer(new Integer(this.sr.getTIMEOUT()-200).longValue(), this.mf.getjLabel4()));
        }
        else{
            //this.executor.shutdown();
            //this.mf.getjLabel4().setText("");
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==this.mf.getjButton1()){
            //Start
            this.sr.initializeConnection(this.mf.getPort(), this.mf.getDataRate());
            this.sr.init(this);
            this.fm.SetFile(new File(this.mf.getjTextField1().getText()));
            this.mf.getjButton1().setEnabled(false);
            this.mf.getjButton2().setEnabled(true);
            this.mf.setEnabledCombo(false);
            
        }
        else if(e.getSource() == this.mf.getjButton2()){
            //Stop
            this.sr.close();
            this.mf.getjButton1().setEnabled(true);
            this.mf.getjButton2().setEnabled(false);
            this.mf.setEnabledCombo(true);
            this.Timer(false);
        }
        else if(e.getSource() == this.mf.getjButton3()){
            //Clear
            this.mf.getjTextArea1().setText("");
        }
        else{
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }
    
}
