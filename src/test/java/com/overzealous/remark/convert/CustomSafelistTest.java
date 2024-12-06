package com.overzealous.remark.convert;

import com.overzealous.remark.Options;
import com.overzealous.remark.Remark;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Lily Espirito Santo
 */
public class CustomSafelistTest {
    @Test
    public void testCustomSafelist() throws Exception {
        Remark remark = new Remark(Options.markdown(), (safelist -> safelist.addProtocols("a","href","tel")));
        String input = "<p><a href=\"tel:12345678\">phone</a></p>";
        String expected = """
                [phone][]
                
                
                [phone]: tel:12345678""";
        Assert.assertEquals(expected, remark.convert(input));
    }
}
