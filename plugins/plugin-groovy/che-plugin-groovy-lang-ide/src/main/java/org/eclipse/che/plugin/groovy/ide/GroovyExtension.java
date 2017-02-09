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
package org.eclipse.che.plugin.groovy.ide;

import static org.eclipse.che.ide.api.action.IdeActions.GROUP_FILE_NEW;
import static org.eclipse.che.plugin.groovy.shared.ProjectAttributes.GROOVY_CATEGORY;

import org.eclipse.che.ide.api.action.ActionManager;
import org.eclipse.che.ide.api.action.DefaultActionGroup;
import org.eclipse.che.ide.api.constraints.Constraints;
import org.eclipse.che.ide.api.extension.Extension;
import org.eclipse.che.ide.api.filetypes.FileType;
import org.eclipse.che.ide.api.filetypes.FileTypeRegistry;
import org.eclipse.che.ide.api.icon.Icon;
import org.eclipse.che.ide.api.icon.IconRegistry;
import org.eclipse.che.plugin.groovy.ide.action.CreateGroovyFileAction;

import com.google.inject.Inject;
import com.google.inject.name.Named;

/**
 * Python extension entry point.
 *
 */
@Extension(title = "Groovy")
public class GroovyExtension {
    @Inject
    public GroovyExtension(FileTypeRegistry fileTypeRegistry,
                           CreateGroovyFileAction createGroovyFileAction,
                           ActionManager actionManager,
                           GroovyResources groovyResources,
                           IconRegistry iconRegistry,
                           @Named("GroovyFileType") FileType groovyFile) {
        fileTypeRegistry.registerFileType(groovyFile);

        DefaultActionGroup newGroup = (DefaultActionGroup)actionManager.getAction(GROUP_FILE_NEW);
        actionManager.registerAction("groovyFile", createGroovyFileAction);
        newGroup.add(createGroovyFileAction, Constraints.FIRST);

        iconRegistry.registerIcon(new Icon(GROOVY_CATEGORY + ".samples.category.icon", groovyResources.category()));
    }

}
