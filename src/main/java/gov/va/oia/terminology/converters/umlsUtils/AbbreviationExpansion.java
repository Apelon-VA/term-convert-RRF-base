package gov.va.oia.terminology.converters.umlsUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import org.apache.commons.lang.StringUtils;

public class AbbreviationExpansion
{
	String abbreviation, expansion, description;

	protected AbbreviationExpansion(String abbreviation, String expansion, String description)
	{
		this.abbreviation = abbreviation;
		this.expansion = expansion;
		this.description = description;
	}

	public String getAbbreviation()
	{
		return abbreviation;
	}

	public String getExpansion()
	{
		return expansion;
	}

	public String getDescription()
	{
		return description;
	}
	
	public static HashMap<String, AbbreviationExpansion> load(InputStream is) throws IOException
	{
		HashMap<String, AbbreviationExpansion> results = new HashMap<>();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.ISO_8859_1));
		String line = br.readLine();
		while (line != null)
		{
			if (StringUtils.isBlank(line) || line.startsWith("#"))
			{
				line = br.readLine();
				continue;
			}
			String[] cols = line.split("\t");
			
			AbbreviationExpansion ae = new AbbreviationExpansion(cols[0], cols[1], (cols.length > 2 ? cols[2] : null));
			
			results.put(ae.getAbbreviation(), ae);
			line = br.readLine();
		}
		return results;
	}
}
