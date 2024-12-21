package com.tdp.ct.web.builder;

import com.google.gson.JsonObject;
import com.tdp.ct.web.model.Agent;
import org.springframework.stereotype.Component;

import static com.tdp.ct.web.lib.WebDriverManager.getDriver;
import static com.tdp.ct.web.utils.FileUtils.getValueConfig;
import static com.tdp.ct.web.utils.JsonModifierAgentData.modifyGroup;
import static com.tdp.ct.web.utils.LogUtils.logInfo;
import static com.tdp.ct.web.utils.SessionStorage.*;

@Component
public class AgentBuilder {

    public static final boolean ADD_RETENTION_ROLE = Boolean.parseBoolean(getValueConfig("config", "environment.agent.add-retention-role"));
    public static final boolean REMOVE_RETENTION_ROLE = Boolean.parseBoolean(getValueConfig("config", "environment.agent.remove-retention-role"));
    public static final String ADD_RETENTION_CHANNEL = getValueConfig("config", "environment.agent.add-retention-role.channels");
    public static final String REMOVE_RETENTION_CHANNEL = getValueConfig("config", "environment.agent.remove-retention-role.channels");

    public static void initializeAgent(Agent agent) {
        JsonObject agentData = getSessionStorageAsJsonObject(getDriver(), "datosAgente");
        populateAgentFromJson(agent, agentData);
    }

    private static void populateAgentFromJson(Agent agent, JsonObject agentData) {
        agent.setFirstName(getValueJsonObjectSessionStorage(agentData, "name"));
        agent.setLastName(getValueJsonObjectSessionStorage(agentData, "surname").trim());
        agent.setChannelType(getValueJsonObjectSessionStorage(agentData, "channels.id").trim());
        agent.setChannelName(getValueJsonObjectSessionStorage(agentData, "sites.1.0.name").trim());
        agent.setDocumentNumber(getValueJsonObjectSessionStorage(agentData, "legalId.nationalID").trim());
        agent.setDocumentType(getValueJsonObjectSessionStorage(agentData, "legalId.nationalIDType").trim());
        agent.setWarehouse(getValueJsonObjectSessionStorage(agentData, "sites.1.1.id").trim());
        agent.setRetention(isRetention());
    }

    public static boolean isRetention() {
        String metadata = getValueJsonObjectSessionStorage(getDriver(), "MSAL_INFO", "metadata");
        return metadata.contains("B2C_FRONTEND_WEB_RETENCIONES");
    }

    public void modifyGroupAgent(String group, Agent agent) {
        logInfo("Agent has rol retention", agent.isRetention());
        String action = validateTheModificationOfTheAgentGroup();
        if ("add".equals(action) && shouldAddRetention(agent)) {
            logInfo(String.format("Add agent %s's retention role", agent.getFullName()));
            updateGroupMetadata(group, "add");
        } else if ("remove".equals(action) && shouldRemoveRetention(agent)) {
            logInfo(String.format("Remove agent %s's retention role", agent.getFullName()));
            updateGroupMetadata(group, "remove");
        } else {
            logInfo("No modify group");
        }
    }

    private boolean shouldAddRetention(Agent agent) {
        return ADD_RETENTION_CHANNEL.contains(agent.getChannelType()) && !agent.isRetention();
    }

    private boolean shouldRemoveRetention(Agent agent) {
        return REMOVE_RETENTION_CHANNEL.contains(agent.getChannelType()) && agent.isRetention();
    }

    private void updateGroupMetadata(String group, String action) {
        String metadata = getValueJsonObjectSessionStorage(getDriver(), "MSAL_INFO", "metadata");
        setValueItemSessionStorage(getDriver(), "MSAL_INFO", "metadata", modifyGroup(metadata, group, action));
    }

    public String validateTheModificationOfTheAgentGroup() {
        if (ADD_RETENTION_ROLE) {
            return "add";
        } else if (REMOVE_RETENTION_ROLE) {
            return "remove";
        } else {
            return "false";
        }
    }

}
