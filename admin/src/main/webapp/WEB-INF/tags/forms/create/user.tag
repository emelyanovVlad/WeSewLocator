<%@ tag language="java" trimDirectiveWhitespaces="true" %>

  <div id="user_create" class="modal fade" role="dialog">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-body">
          <form class="form-horizontal" data-target="/users/add" method="POST">
            <fieldset>
              <div class="form-group">
                <label for="inputName" class="col-lg-3 control-label">Email</label>
                <div class="col-lg-9">
                  <input name="email" type="text" class="form-control" id="inputName">
                </div>
              </div>
              <div class="form-group">
                <label for="inputPassword" class="col-lg-3 control-label">Password</label>
                <div class="col-lg-9">
                  <input name="password" type="password" class="form-control" id="inputPassword">
                </div>
              </div>
              <div class="form-group">
                <label for="inputFullName" class="col-lg-3 control-label">Full name</label>
                <div class="col-lg-9">
                  <input name="fullName" type="text" class="form-control" id="inputFullName">
                </div>
              </div>
              <div class="form-group">
                <label for="inputBirthDate" class="col-lg-3 control-label">Birth date</label>
                <div class="col-lg-9">
                  <input name="birthDate" type="date" class="form-control" id="inputBirthDate">
                </div>
              </div>
              <div class="form-group">
                <label for="selectRole" class="col-lg-3 control-label">Role</label>
                <div class="col-lg-9">
                  <select id='selectRole' name="roleName" class='form-control' data-target="/roles">

                  </select>
                </div>
              </div>
            </fieldset>
          </form>
        </div>
        <div class="modal-footer">
            <button type="reset" class="btn btn-default" data-dismiss="modal">Hide</button>
            <button type="submit" class="btn btn-primary">Go</button>
        </div>
      </div>
    </div>
  </div>
