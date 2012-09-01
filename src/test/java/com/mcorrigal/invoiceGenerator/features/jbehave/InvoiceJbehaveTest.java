package com.mcorrigal.invoiceGenerator.features.jbehave;

import static org.jbehave.core.reporters.StoryReporterBuilder.Format.CONSOLE;
import static org.jbehave.core.reporters.StoryReporterBuilder.Format.HTML;
import static org.jbehave.core.reporters.StoryReporterBuilder.Format.TXT;
import static org.jbehave.core.reporters.StoryReporterBuilder.Format.XML;

import java.util.Arrays;
import java.util.List;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.junit.runner.RunWith;

import de.codecentric.jbehave.junit.monitoring.JUnitReportingRunner;

@RunWith(JUnitReportingRunner.class)
public class InvoiceJbehaveTest extends JUnitStories {

	public InvoiceJbehaveTest() {
		super();
	}
	
	@Override
	public InjectableStepsFactory stepsFactory() {
		return new InstanceStepsFactory(configuration(), new InvoiceJbehaveSteps());
	}
	
	@Override
    public Configuration configuration() {
        return new MostUsefulConfiguration().useStoryReporterBuilder(new StoryReporterBuilder().withFormats(CONSOLE, TXT, HTML, XML));
    }
 
	@Override
	protected List<String> storyPaths() {
		return Arrays.asList("com/mcorrigal/invoiceGenerator/features/jbehave/invoice_jbehave_test.story");
	}
	
}
