package at.twinformatics.atlas.plugin.jira.ticketslayer.customfield;

import com.atlassian.jira.issue.Issue;
import com.atlassian.jira.issue.customfields.impl.CalculatedCFType;
import com.atlassian.jira.issue.customfields.impl.FieldValidationException;
import com.atlassian.jira.issue.fields.CustomField;
import com.atlassian.jira.issue.fields.config.FieldConfig;
import com.atlassian.jira.issue.fields.layout.field.FieldLayoutItem;
import com.atlassian.plugin.spring.scanner.annotation.component.Scanned;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

@Scanned
public class MonsterPowerCustomField extends CalculatedCFType<Integer, Integer> {
    private static final Logger log = LoggerFactory.getLogger(MonsterPowerCustomField.class);

    public MonsterPowerCustomField() {
    }

    @Override
    public String getStringFromSingularObject(final Integer integer) {
        return integer != null ? integer.toString() : null;
    }

    @Override
    public Integer getSingularObjectFromString(final String s) throws FieldValidationException {
        try {
            return s != null && !s.isEmpty() ? Integer.parseInt(s) : null;
        } catch (final NumberFormatException e) {
            throw new FieldValidationException(e.getMessage());
        }
    }

    @Override
    public Integer getValueFromIssue(CustomField customField, Issue issue) {
        return 0;
    }

    @Override
    public Map<String, Object> getVelocityParameters(final Issue issue,
                                                     final CustomField field,
                                                     final FieldLayoutItem fieldLayoutItem) {
        final Map<String, Object> map = super.getVelocityParameters(issue, field, fieldLayoutItem);

        // This method is also called to get the default value, in
        // which case issue is null so we can't use it to add currencyLocale
        if (issue == null) {
            return map;
        }

         FieldConfig fieldConfig = field.getRelevantConfig(issue);
         //add what you need to the map here

        return map;
    }
}