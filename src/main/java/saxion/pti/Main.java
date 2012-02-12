package saxion.pti;

import java.io.IOException;
import java.io.InputStream;

import org.apache.log4j.Logger;

import saxion.pti.ast.BuildTree;
import saxion.pti.ast.VisitTree;
import saxion.pti.generated.Yylex;
import saxion.pti.generated.parser;

/**
 * Main entry point :)
 * 
 * @author Joost Limburg
 * 
 */
public class Main {
	// Logging
	static final Logger LOGGER = Logger.getLogger(Main.class);

	public static void main(String[] args) {
		// Check de parameters
		if (args.length != 1) {
			LOGGER.error("Invalid number of parameters, usage: Fava <filename>");
			System.exit(-1);
		}

		// Stream to read file
		try {
			// Open een inputstream
			InputStream finput = Main.class.getResourceAsStream("../../"
					+ args[0]);

			// Check de inputstream
			if (finput != null) {
				parser p = new parser(new Yylex(finput));
				try {
					BuildTree result = (BuildTree)p.parse().value;
					
					result.debugMsg("Max depth of tree: " + result.getMaxDepth());
					
					VisitTree treeVisitor = new VisitTree(result, "Test");
					treeVisitor.start();
					
				} catch (Exception e) {
					LOGGER.error("Error while parsing.", e);
					System.exit(-3);
				}
			} else {
				throw new IOException("File not found");
			}
		}
		// Catches any error conditions
		catch (IOException e) {
			LOGGER.error("Unable to read from file: " + args[0]);
			System.exit(-2);
		}

	}
}
