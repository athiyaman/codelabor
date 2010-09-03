/*
 * Licensed to the Apache Software Foundimport java.io.File;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.mail.internet.MimeMessage;

import org.codelabor.system.dtos.MailDTO;
import org.codelabor.system.exceptions.CommonException;
import org.codelabor.system.exceptions.RollbackCommonException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
es/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.codelabor.system.remoting.message.services;

public interface MessageHandlerService {
	public String handleMessage(String inputMessage) throws Exception;
}
