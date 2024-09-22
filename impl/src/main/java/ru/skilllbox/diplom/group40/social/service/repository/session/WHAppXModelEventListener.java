//==================================================
//
//  Copyright 2012 Siemens Product Lifecycle Management Software Inc. All Rights Reserved.
//
//==================================================

package ru.skilllbox.diplom.group40.social.service.repository.session;


import com.teamcenter.soa.client.model.ModelEventListener;
import com.teamcenter.soa.client.model.ModelObject;

/**
 * Implementation of the ChangeListener. Print out all objects that have been updated.
 *
 */
public class WHAppXModelEventListener extends ModelEventListener
{

    @Override
    public void localObjectChange(ModelObject[] objects)
    {

    }

    @Override
    public void localObjectDelete(String[] uids)
    {
        if (uids.length == 0)
            return;
    }

}
