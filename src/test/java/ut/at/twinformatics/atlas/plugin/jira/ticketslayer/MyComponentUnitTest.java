package ut.at.twinformatics.atlas.plugin.jira.ticketslayer;

import org.junit.Test;
import at.twinformatics.atlas.plugin.jira.ticketslayer.api.MyPluginComponent;
import at.twinformatics.atlas.plugin.jira.ticketslayer.impl.MyPluginComponentImpl;

import static org.junit.Assert.assertEquals;

public class MyComponentUnitTest
{
    @Test
    public void testMyName()
    {
        MyPluginComponent component = new MyPluginComponentImpl(null);
        assertEquals("names do not match!", "myComponent",component.getName());
    }
}