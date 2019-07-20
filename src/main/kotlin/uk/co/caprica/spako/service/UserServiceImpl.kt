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

package uk.co.caprica.spako.service

import uk.co.caprica.spako.domain.User
import uk.co.caprica.spako.repository.MemoryUserRepository

class UserServiceImpl : UserService {

    // Use static singleton component instances for services and repositories, or any dependency injection framework
    private val userRepository = MemoryUserRepository()

    override fun users(): List<User> {
        return userRepository.readUsers()
    }

    override fun user(username: String): User? {
        return userRepository.readUser(username)
    }

}
