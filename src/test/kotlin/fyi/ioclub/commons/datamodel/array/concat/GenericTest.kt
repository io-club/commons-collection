/*
 * Copyright 2025 IO Club
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package fyi.ioclub.commons.datamodel.array.concat

import fyi.ioclub.commons.datamodel.array.slice.asSlice
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

class GenericTest {

    data class MyObj(val n: Int)

    @Test
    fun testConcat2() {
        val a1 = listOf(1, 2).map(::MyObj).toTypedArray()
        val a2 = arrayOf(MyObj(3))

        val aim = listOf(2, 3).map(::MyObj).toTypedArray()
        val ac = concat(MyObj::class.java, a1.asSlice(1, 1), a2.asSlice())
        assertTrue(ac contentEquals aim)
    }

    @Test
    fun testConcatN() {
        val a1 = listOf(1, 2).map(::MyObj).toTypedArray()
        val a2 = arrayOf(MyObj(3))
        val a3 = arrayOf(MyObj(4))

        val aim = listOf(2, 3, 4).map(::MyObj).toTypedArray()
        val ac1 = concat(MyObj::class.java, a1.asSlice(1, 1), a2.asSlice(), a3.asSlice())
        assertContentEquals(aim, ac1)
        val ac2 = concat(MyObj::class.java, listOf(a1.asSlice(1, 1), a2.asSlice(), a3.asSlice()))
        assertContentEquals(aim, ac2)
    }
}
