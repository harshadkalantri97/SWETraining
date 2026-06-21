package sweTraining.miscellaneous;
import java.util.ArrayList;

import org.apache.commons.lang3.StringUtils;

public class practNewValues
{
   private String[] CARRIER_DATABLOCKID = new String[] { "vsDataTransport,vsDataInterfaces,vsDataInterface_LAN",
      "vsDataTransport,vsDataInterfaces,vsDataInterface_WAN", "vsDataTransport,vsDataInterfaces,vsDataInterface_RLT",
      "vsDataTransport,vsDataInterfaces,vsDataInterface_CT", "vsDataTransport,vsDataInterfaces,vsDataInterface_E1",
      "vsDataTransport,vsDataInterfaces,vsDataInterface,vsDataEthernet_WAN", "vsDataTransport,vsDataInterfaces,vsDataInterface,vsDataEthernet_LAN",
      "vsDataTransport,vsDataInterfaces,vsDataInterface,vsDataCarrierTermination",
      "vsDataTransport,vsDataInterfaces,vsDataInterface,vsDataCarrierTermination,vsDataFarEndCarrierTermination",
      "vsDataTransport,vsDataInterfaces,vsDataInterface,vsDataRadioLinkTerminal",
      "vsDataTransport,vsDataInterfaces,vsDataInterface,vsDataRadioLinkTerminal,vsDataTdmConnection",
      "vsDataTransport,vsDataInterfaces,vsDataInterface,vsDataRadioLinkTerminal,vsDataFarEndRadioLinkTerminal",
      "vsDataTransport,vsDataInterfaces,vsDataInterface,vsDataEthernet,vsDataLldpData_LAN",
      "vsDataTransport,vsDataInterfaces,vsDataInterface,vsDataEthernet,vsDataLldpData_WAN",
      "vsDataTransport,vsDataInterfaces,vsDataInterface,vsDataSwitchPortConfig_LAN",
      "vsDataTransport,vsDataInterfaces,vsDataInterface,vsDataSwitchPortConfig_WAN",
      "vsDataTransport,vsDataInterfaces,vsDataInterface,vsDataSwitchPortConfig,vsDataCeVlanEvcSetting_WAN",
      "vsDataTransport,vsDataInterfaces,vsDataInterface,vsDataSwitchPortConfig,vsDataCeVlanEvcSetting_LAN" };

   public static void main(String[] args)
   {
      String input = "<es:switchAdminStatus></es:switchAdminStatus>\n"
         + "<es:carrierTerminations>SubNetwork=MP,SubNetwork=MINILINK,MeContext=IDMP104523-IEIE-H-E-T6P1,ManagedElement=IDMP104523-IEIE-H-E-T6P1,Transport=1,Interfaces=1,Interface=CT-1/4/1,CarrierTermination=1</es:carrierTerminations>\n"
         + "<es:carrierTerminations>SubNetwork=MP,SubNetwork=MINILINK,MeContext=IDMP104523-IEIE-H-E-T6P1,ManagedElement=IDMP104523-IEIE-H-E-T6P1,Transport=1,Interfaces=1,Interface=CT-1/4/2,CarrierTermination=1</es:carrierTerminations>\n"
         + "<es:tdmConnections>SubNetwork=MP,SubNetwork=MINILINK,MeContext=IDMP104523-IEIE-H-E-T6P1,ManagedElement=IDMP104523-IEIE-H-E-T6P1,Transport=1,Interfaces=1,Interface=RLT-1/4/1,RadioLinkTerminal=1,TdmConnection=1</es:tdmConnections>";

      String[] lines = input.split("\n");
      ArrayList<String> output = new ArrayList<>();
      for (String line : lines)
      {
         if (line.contains("<es:carrierTerminations>"))
         {
            String[] values = line.split(",");
            String subnetwork = "", managedElement = "", interfaceName = "";
            for (String value : values)
            {
               if (value.startsWith("SubNetwork"))
                  subnetwork = value;
               else if (value.startsWith("ManagedElement"))
                  managedElement = value;
               else if (value.startsWith("Interface"))
                  interfaceName = value;
            }
            output.add(subnetwork + "," + managedElement + "," + interfaceName);
         }
      }

      String result = StringUtils.join(",", output);
      System.out.println(result);
   }
}
