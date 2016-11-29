package api 
import api.Role
import api.User
import api.UserRole

class BootStrap {

    def init = { servletContext ->
        User user = new User ("user", "pass").save()
        Role admin = new Role ("ROLE_ADMIN").save()
        UserRole.create(user, admin, true)
    }
    def destroy = {
    }
}
