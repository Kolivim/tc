package ru.skilllbox.diplom.group40.social.service.service.drawing;

import com.teamcenter.schemas.soa._2006_03.exceptions.ServiceException;
import com.teamcenter.services.strong.core.DataManagementService;
import com.teamcenter.services.strong.core.SessionService;
import com.teamcenter.services.strong.core._2008_06.DataManagement;
import com.teamcenter.soa.client.Connection;
import com.teamcenter.soa.client.model.strong.Item;
import com.teamcenter.soa.client.model.strong.ItemRevision;
import com.teamcenter.soa.common.ObjectPropertyPolicy;
import ru.skilllbox.diplom.group40.social.service.dto.drawing.DrawingDto;
import ru.skilllbox.diplom.group40.social.service.repository.session.KolivimSession;


import java.util.List;

public class CreateDrawing {
    DataManagement dataManagement;

    public CreateDrawing() {}

    public void createItem (int countItems, DrawingDto drawingDto, String itemType,
                            List<Item> itemsList, List<ItemRevision> revsList,
                            Connection connection, KolivimSession kolivimSession) {

        dataManagement = DataManagementService.getService(connection);

        DataManagement.CreateIn[] createObjectsIn = getCreateIn(itemType, drawingDto);

        setObjectPolicy2(connection, kolivimSession, drawingDto.getCreateObjectType());

        try {
            DataManagement.CreateResponse createResponse = dataManagement.createObjects(createObjectsIn);
        } catch (ServiceException e) {
            System.out.println("    CreateDrawing: createItem() catch in *dataManagement.createObjects* : " + e.getMessage());
        }

    }

    private DataManagement.CreateIn[] getCreateIn(String itemType, DrawingDto drawingDto) {

        DataManagement.CreateIn createIn = new DataManagement.CreateIn();
        createIn.clientId = "AddDrawingItem";

        DataManagement.CreateInput createInput = createIn.data;
        createInput.boName = drawingDto.getCreateObjectType();
        createInput.stringProps.put("object_desc", drawingDto.getName());
        createInput.stringProps.put("item_id", drawingDto.getNumber());
        createInput.stringProps.put("object_name", drawingDto.getNumber());

        DataManagement.CreateInput itemRevisionInput = new DataManagement.CreateInput();
        itemRevisionInput.boName = drawingDto.getCreateObjectType().concat("Revision");
        itemRevisionInput.stringProps.put("va49_number", drawingDto.getCode());
        itemRevisionInput.stringProps.put("item_revision_id", "00");    // TODO: исправить - принять из КОНСТАНТ

        createInput.compoundCreateInput.put("revision", new DataManagement.CreateInput[]{itemRevisionInput});
//        createInput.compoundCreateInput.put("revision", itemRevisionInput);

        DataManagement.CreateIn[] createObjectsInput = new DataManagement.CreateIn[]{createIn};

        return createObjectsInput;
    }

    private void setObjectPolicy2(Connection connection, KolivimSession kolivimSession, String itemType){

        SessionService sessionService = SessionService.getService(connection);

        ObjectPropertyPolicy policy = new ObjectPropertyPolicy();

        policy.addType(itemType, new String[]{"va49_mdm_code", "item_id", "object_name", "object_desc", "revision_list", "item_master_tag"});
        policy.addType(itemType.concat("Revision"), new String[]{"item_revision_id", "va49_number"});

        String policyName = sessionService.setObjectPropertyPolicy(policy);

        System.out.println("CreateDrawing: setObjectPolicy2() set policy = " + policyName);
    }

}
