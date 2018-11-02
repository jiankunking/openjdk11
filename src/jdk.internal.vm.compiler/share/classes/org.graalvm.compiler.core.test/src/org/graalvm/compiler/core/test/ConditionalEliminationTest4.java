/*
 * Copyright (c) 2015, 2015, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */


package org.graalvm.compiler.core.test;

import org.junit.Test;

/**
 * Collection of tests for {@link org.graalvm.compiler.phases.common.ConditionalEliminationPhase}
 * including those that triggered bugs in this phase.
 */
public class ConditionalEliminationTest4 extends ConditionalEliminationTestBase {

    @SuppressWarnings("all")
    public static int reference1Snippet(int a, int b) {
        if (a > b) {
            return 1;
        }
        return 2;
    }

    @SuppressWarnings("all")
    public static int test1Snippet(int a, int b) {
        if (a > b) {
            if (a > b) {
                return 1;
            }
        }
        return 2;
    }

    @Test
    public void test1() {
        testConditionalElimination("test1Snippet", "reference1Snippet");
    }

    @SuppressWarnings("all")
    public static int reference2Snippet(int a, int b) {
        if (a < b) {
            return 1;
        }
        return 2;
    }

    @SuppressWarnings("all")
    public static int test2Snippet(int a, int b) {
        if (a < b) {
            if (a < b) {
                return 1;
            }
        }
        return 2;
    }

    @Test
    public void test2() {
        testConditionalElimination("test2Snippet", "reference2Snippet");
    }
}
