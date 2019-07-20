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

package uk.co.caprica.spako.controller

import io.javalin.http.Context
import uk.co.caprica.spako.domain.User
import uk.co.caprica.spako.service.UserServiceImpl

/**
 * An example web service API controller.
 */
object UserController {

    // Use static singleton component instances for services and repositories, or any dependency injection framework
    private val userService = UserServiceImpl()

    val users: (Context)->Unit = { ctx ->
        // Add a fake delay so we can see state changes in the UI
        try {
            Thread.sleep(1000)
        } catch (e: InterruptedException) {
        }

        ctx.json(userService.users())
    }

    val user: (Context)->Unit = { ctx ->
        // Add a fake delay so we can see state changes in the UI
        try {
            Thread.sleep(1000)
        } catch (e: InterruptedException) {
        }

        val user: User? = userService.user(ctx.pathParam("username"))
        if (user != null) ctx.json(user) else ctx.status(404)
    }

}
