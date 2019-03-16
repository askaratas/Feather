import java.util.ArrayList;
import java.io.*;


/** *******************************************************************************************
 * Feather_CodeGenerator
 * --------------------------------------------------------------------------------------------
 * @author Ahmet Serkan Karatas
 *
 ** ******************************************************************************************* */
class Feather_CodeGenerator
{
	public static boolean generateCode(Feature root, ArrayList<Feature> featureList, ArrayList<CrossTreeConstraint> constraintList, String fileName)
	{
		String code;
		
		code  = generateFeatureDeclarationsCode(root, featureList);
		code += generateConstraintDeclarationsCode(constraintList);
		
		FileWriter featherFile;
		BufferedWriter bufferedWriter;
		try
		{
			featherFile = new FileWriter(fileName);
			bufferedWriter = new BufferedWriter(featherFile);
			bufferedWriter.write(code);
			bufferedWriter.close();
		}
		catch (Exception e)
		{
			return false;
		}
		
		return true;
	}
	
	
	private static String generateFeatureDeclarationsCode(Feature root, ArrayList<Feature> featList)
	{
		if ( root == null )
		{
			return "";
		}
		
		String code;
		
		code = "root \"" + root._name + "\"\r\n";
		code += generateAttributeDeclarationsCode(root.attributes);
		code += ";\r\n";
		
		if ( featList == null || featList.size() == 0 )
		{
			return code;
		}
		
		int i, j;
		Feature feat, par, relSib;
		
		for (i=0; i < featList.size(); i++)
		{
			feat = featList.get(i);
			
			if ( feat.idNo == root.idNo )
			{
				continue;
			}
			
			code += "feature \"" + feat._name + "\" ";
			
			par = null;
			for (j=0; j < featList.size(); j++)
			{
				if ( feat._parentIDNo == featList.get(j).idNo )
				{
					par = featList.get(j);
					break;
				}
			}
			if ( par == null )
			{
				return "";
			}
			
			code += " \"" + par._name + "\" ";
			
			if ( feat._decomp == Codes.MANDATORY )
			{
				code += " mandatory ";
			}
			else if ( feat._decomp == Codes.OPTIONAL )
			{
				code += " optional ";
			}
			else if ( feat._decomp == Codes.ALTERNATIVE )
			{
				if ( feat._decompID == Codes._NO_VALUE_ )
				{
					code += " mandatory ";
				}
				else
				{
					relSib = null;
					for (j=0; j < featList.size(); j++)
					{
						if ( feat.idNo == featList.get(j).idNo )
						{
							continue;
						}
						if ( feat._decompID == featList.get(j)._decompID )
						{
							relSib = featList.get(j);
							break;
						}
					}
					if ( relSib == null )
					{
						code += " mandatory ";
					}
					else
					{
						code += " alternative to \"" + relSib._name + "\" ";
					}
				}
			}
			else if ( feat._decomp == Codes.OR )
			{
				if ( feat._decompID == Codes._NO_VALUE_ )
				{
					code += " mandatory ";
				}
				else
				{
					relSib = null;
					for (j=0; j < featList.size(); j++)
					{
						if ( feat.idNo == featList.get(j).idNo )
						{
							continue;
						}
						if ( feat._decompID == featList.get(j)._decompID )
						{
							relSib = featList.get(j);
							break;
						}
					}
					if ( relSib == null )
					{
						code += " mandatory ";
					}
					else
					{
						code += " or to \"" + relSib._name + "\" ";
					}
				}
			}
			
			code += "\r\n" + generateAttributeDeclarationsCode(feat.attributes) + ";\r\n";
		}
		
		return code;
	}
	
	private static String generateAttributeDeclarationsCode(ArrayList<Attribute> attrList)
	{
		if ( attrList == null || attrList.size() == 0 )
		{
			return "";
		}
		
		int i;
		Attribute attr;
		String code = "";
		
		for (i=0; i < attrList.size(); i++)
		{
			attr = attrList.get(i);
			
			code += "  attribute " + attr.name + " ";
			
			switch ( attr.type )
			{
				case Codes.TYPE_INT:    code += attr.intval + "\r\n"; break;
				case Codes.TYPE_REAL:   code += attr.realval + "\r\n"; break;
				case Codes.TYPE_BOOL:   code += attr.boolval + "\r\n"; break;
				case Codes.TYPE_STRING: code += "\"" + attr.stringval + "\"\r\n"; break;
			}
		}
		
		return code;
	}
	
	private static String generateConstraintDeclarationsCode(ArrayList<CrossTreeConstraint> ctcList)
	{
		if ( ctcList == null || ctcList.size() == 0 )
		{
			return "";
		}
		
		int i;
		CrossTreeConstraint ctc;
		String code = "";
		
		for (i=0; i < ctcList.size(); i++)
		{
			ctc = ctcList.get(i);
			
			code += "constraint \"" + ctc.leftFeature + "\"" + (ctc.constraintType == Codes.REQUIRES ? " requires " : " excludes ") + "\"" + ctc.rightFeature + "\" ;\r\n" ;
		}
		
		return code;
	}
}













