/*
 * Copyright 2009 Red Hat, Inc.
 * Red Hat licenses this file to you under the Apache License, version
 * 2.0 (the "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *    http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 * implied.  See the License for the specific language governing
 * permissions and limitations under the License.
 */

package org.hornetq.jms.tests.message;

import javax.jms.Message;

import org.hornetq.jms.tests.util.ProxyAssertSupport;

/**
 * @author <a href="mailto:dua_rajdeep@yahoo.com">Rajdeep Dua</a>
 * @version <tt>$Revision: 8611 $</tt>
 */
public class JMSTypeHeaderTest extends MessageHeaderTestBase
{
   // Constants -----------------------------------------------------

   // Static --------------------------------------------------------

   // Attributes ----------------------------------------------------

   // Constructors --------------------------------------------------

   // Public --------------------------------------------------------

   public void testJMSType() throws Exception
   {
      Message m = queueProducerSession.createMessage();
      String originalType = "TYPE1";
      m.setJMSType(originalType);
      queueProducer.send(m);
      String gotType = queueConsumer.receive(1000).getJMSType();
      ProxyAssertSupport.assertEquals(originalType, gotType);
   }

   public void testNULLJMSType() throws Exception
   {
      Message m = queueProducerSession.createMessage();
      queueProducer.send(m);
      ProxyAssertSupport.assertEquals(null, queueConsumer.receive(1000).getJMSType());
   }

   // Package protected ---------------------------------------------

   // Protected -----------------------------------------------------

   // Private -------------------------------------------------------

   // Inner classes -------------------------------------------------

}
