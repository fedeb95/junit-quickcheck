/*
 The MIT License

 Copyright (c) 2010-2012 Paul R. Holser, Jr.

 Permission is hereby granted, free of charge, to any person obtaining
 a copy of this software and associated documentation files (the
 "Software"), to deal in the Software without restriction, including
 without limitation the rights to use, copy, modify, merge, publish,
 distribute, sublicense, and/or sell copies of the Software, and to
 permit persons to whom the Software is furnished to do so, subject to
 the following conditions:

 The above copyright notice and this permission notice shall be
 included in all copies or substantial portions of the Software.

 THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.pholser.junit.quickcheck.internal.constraint;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static com.pholser.junit.quickcheck.internal.constraint.ConstraintEvaluator.*;
import static org.junit.Assert.*;
import static org.junit.rules.ExpectedException.*;

public class ConstraintEvaluatorTest {
    @Rule public final ExpectedException thrown = none();

    private ConstraintEvaluator evaluator;

    @Before
    public void beforeEach() {
        evaluator = new ConstraintEvaluator();
    }

    @Test
    public void whenExpressionEvaluatesTrue() {
        assertTrue(evaluator.evaluate("#root > 0", 1));
    }

    @Test
    public void whenExpressionEvaluatesFalse() {
        assertFalse(evaluator.evaluate("#root > 0", -2));
    }

    @Test
    public void whenExpressionIsMalformed() {
        thrown.expect(EvaluationException.class);

        evaluator.evaluate("#root !*@&#^*", 0);
    }
}
