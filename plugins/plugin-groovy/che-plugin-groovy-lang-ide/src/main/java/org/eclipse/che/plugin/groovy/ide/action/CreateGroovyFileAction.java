/*******************************************************************************
 * Copyright (c) 2012-2017 Codenvy, S.A.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Codenvy, S.A. - initial API and implementation
 *******************************************************************************/
package org.eclipse.che.plugin.groovy.ide.action;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.web.bindery.event.shared.EventBus;

import org.eclipse.che.ide.CoreLocalizationConstant;
import org.eclipse.che.ide.api.app.AppContext;
import org.eclipse.che.ide.api.dialogs.DialogFactory;
import org.eclipse.che.ide.api.notification.NotificationManager;
import org.eclipse.che.ide.newresource.AbstractNewResourceAction;
import org.eclipse.che.plugin.groovy.ide.GroovyLocalizationConstant;
import org.eclipse.che.plugin.groovy.ide.GroovyResources;

import static org.eclipse.che.plugin.groovy.shared.ProjectAttributes.GROOVY_EXT;

/**
 * Action to create new Groovy source file.
 *
 */
@Singleton
public class CreateGroovyFileAction extends AbstractNewResourceAction {

    @Inject
    public CreateGroovyFileAction(GroovyLocalizationConstant localizationConstant,
                                  GroovyResources groovyResources,
                                  DialogFactory dialogFactory,
                                  CoreLocalizationConstant coreLocalizationConstant,
                                  EventBus eventBus,
                                  AppContext appContext,
                                  NotificationManager notificationManager) {
        super(localizationConstant.createGroovyFileActionTitle(),
              localizationConstant.createGroovyFileActionDescription(),
              groovyResources.groovyFile(), dialogFactory, coreLocalizationConstant, eventBus, appContext, notificationManager);
    }

    @Override
    protected String getExtension() {
        return GROOVY_EXT;
    }

    @Override
    protected String getDefaultContent() {
        return "";
    }

}
