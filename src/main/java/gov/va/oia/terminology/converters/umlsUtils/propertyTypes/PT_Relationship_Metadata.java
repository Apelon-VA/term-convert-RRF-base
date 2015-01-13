package gov.va.oia.terminology.converters.umlsUtils.propertyTypes;

import gov.va.oia.terminology.converters.sharedUtils.propertyTypes.PropertyType;

/**
 * @author Daniel Armbrust
 */
public class PT_Relationship_Metadata extends PropertyType
{
	public PT_Relationship_Metadata()
	{
		super("Relationship Metadata");
		indexByAltNames();
		addProperty("Inverse FSN");
		addProperty("Inverse Synonym");
		addProperty("Inverse Description");
		addProperty("General Rel Type");
		addProperty("Inverse General Rel Type");
		addProperty("Snomed Code");
		addProperty("Inverse Snomed Code");
		addProperty("Source AUI and Target AUI", null, "sAUI & tAUI", "The Source AUI and Target AUI that defines the actual source of the relationship.  Source is first, Target is second - seperated by \" -> \".  Required since multiple AUI atoms are combined to create a single WB concept.");
	}
}
