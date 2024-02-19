package gash.payload;

/**
 * the builder to construct commands that both the client (BasicSocketClient)
 * and server (BasicServer) understands/accepts
 * 
 * @author gash
 * 
 */
public class BasicBuilder {

	public BasicBuilder() {
	}

	public String encode(Message msg) {
		var sb = new StringBuilder();
		sb.append(msg.getGroup()).append(",").append(msg.getName()).append(",").append(msg.getText());
		
		String payload = sb.toString(); // Example payload
		String formattedString = String.format("%04d,%s", payload.length(), payload);

		return 
		formattedString;
	}

	public Message decode(byte[] raw) throws Exception {
		if (raw == null || raw.length == 0)
			return null;
		
		var s = new String(raw);
		System.out.println(s);
		var parts = s.split(",", 4);
		var rtn = new Message(parts[1], parts[2], parts[3]);

		return rtn;
	}

}
