/*
 * Zed Attack Proxy (ZAP) and its related class files.
 * 
 * ZAP is an HTTP/HTTPS proxy for assessing web application security.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at 
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0 
 *   
 * Unless required by applicable law or agreed to in writing, software 
 * distributed under the License is distributed on an "AS IS" BASIS, 
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
 * See the License for the specific language governing permissions and 
 * limitations under the License. 
 */
package org.zaproxy.zap.extension.plugnhack.fuzz;

import javax.swing.JPanel;

import org.zaproxy.zap.extension.fuzz.ExtensionFuzz;
import org.zaproxy.zap.extension.fuzz.FuzzDialog;
import org.zaproxy.zap.extension.fuzz.FuzzProcessFactory;
import org.zaproxy.zap.extension.fuzz.FuzzableComponent;
import org.zaproxy.zap.extension.plugnhack.ExtensionPlugNHack;
import org.zaproxy.zap.extension.plugnhack.httppanel.views.ClientFuzzableTextMessage;

public class ClientMessageFuzzDialog extends FuzzDialog {

    private static final long serialVersionUID = 9056386749268459789L;

    private ExtensionPlugNHack extension;
    private ClientFuzzableTextMessage  fuzzableMessage;

    public ClientMessageFuzzDialog(ExtensionFuzz extension, ExtensionPlugNHack extPnH, FuzzableComponent fuzzableComponent) {
        super(extension, fuzzableComponent.getFuzzTarget());
        this.extension = extPnH;
        
        fuzzableMessage = (ClientFuzzableTextMessage) fuzzableComponent.getFuzzableMessage();
        
        initialize();
    }

    /**
	 * Allows to reuse the existing dialog for another fuzz session. This means
	 * no previous selection gets lost for this {@link ClientMessageFuzzDialog}.
	 * 
	 * @param fuzzableComponent
	 */
	public void setFuzzableComponent(FuzzableComponent fuzzableComponent) {
		setSelection(fuzzableComponent.getFuzzTarget());
		fuzzableMessage = (ClientFuzzableTextMessage) fuzzableComponent.getFuzzableMessage();
	}
    
    @Override
    protected int addCustomComponents(JPanel panel, int row) {
        int currentRow = row;

        // Add more fields if needed.
        
        return currentRow;
    }
    
    @Override
    protected FuzzProcessFactory getFuzzProcessFactory() {
        return new ClientMessageFuzzProcessFactory(extension, fuzzableMessage);
    }
}