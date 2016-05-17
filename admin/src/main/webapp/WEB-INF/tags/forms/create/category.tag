<%@ tag language="java" trimDirectiveWhitespaces="true" %>

<div id="category_create" class="modal fade" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-body">
                <form class="form-horizontal" data-target="/categories/add" method="POST">
                    <fieldset>
                        <div class="form-group">
                            <label for="inputName" class="col-lg-3 control-label">Category name</label>
                            <div class="col-lg-9">
                                <input name="name" type="text" class="form-control" id="inputName">
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