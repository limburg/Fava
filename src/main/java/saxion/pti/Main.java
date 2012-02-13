package saxion.pti;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.LinkedList;

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

	private static void doWriteJasmin(String file, LinkedList<String> contents) {
		try {
			PrintWriter output = new PrintWriter(new File(file));

			for (String line : contents)
				output.write(line + "\n");

			output.close();
		} catch (Exception e) {
			LOGGER.error("Could not write to file: " + file);
		}

	}

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
					BuildTree result = (BuildTree) p.parse().value;

					result.debugMsg("Max depth of tree: "
							+ result.getMaxDepth());

					VisitTree treeVisitor = new VisitTree(result, "Test");
					treeVisitor.start();

					doWriteJasmin("jasmin/test.j", treeVisitor.getCode());
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
