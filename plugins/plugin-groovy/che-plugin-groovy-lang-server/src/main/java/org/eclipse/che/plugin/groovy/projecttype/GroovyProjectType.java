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
package org.eclipse.che.plugin.groovy.projecttype;

import com.google.inject.Inject;

import org.eclipse.che.api.project.server.type.ProjectTypeDef;

import static org.eclipse.che.plugin.groovy.shared.ProjectAttributes.LANGUAGE;
import static org.eclipse.che.plugin.groovy.shared.ProjectAttributes.GROOVY_ID;
import static org.eclipse.che.plugin.groovy.shared.ProjectAttributes.GROOVY_NAME;


/**
 * Python  project type.
 *
 * @author Valeriy Svydenko
 */
public class GroovyProjectType extends ProjectTypeDef {
    @Inject
    public GroovyProjectType() {
        super(GROOVY_ID, GROOVY_NAME, true, false, true);
        addConstantDefinition(LANGUAGE, LANGUAGE, GROOVY_ID);
    }

}
