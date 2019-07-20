/*
 * This file is part of Spa.
 *
 * Copyright (C) 2019
 * Caprica Software Limited (capricasoftware.co.uk)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 *
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

package uk.co.caprica.spako.repository

import uk.co.caprica.spako.domain.User
import java.util.*

class MemoryUserRepository : UserRepository {

    override fun readUsers(): List<User> {
        return Collections.unmodifiableList(ArrayList(users.values))
    }

    override fun readUser(username: String): User? {
        return users[username]
    }

    companion object {

        private val users = HashMap<String, User>()

        init {
            users["boss"] = User("boss", "Sword Saint Isshin")
            users["emma"] = User("emma", "The Gentle Blade")
            users["emo"] = User("emo", "Genichiro")
            users["dad"] = User("dad", "Great Shinobi Owl")
            users["bananas"] = User("bananas", "Guardian Ape")
            users["granny"] = User("granny", "Lady Butterfly")
            users["horseguy"] = User("horseguy", "Gyoubu Masataka Oniwa")
            users["scorchio"] = User("scorchio", "Demon of Hatred")
        }
    }

}
