<%@ tag language="java" trimDirectiveWhitespaces="true" %>

<div id="location_create" class="modal fade" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-body">
                <form class="form-horizontal" data-target="/locations/add" method="POST">
                    <fieldset>
                        <div class="form-group">
                            <label for="inputName" class="col-lg-3 control-label">Location name</label>
                            <div class="col-lg-9">
                                <input name="name" type="text" class="form-control" id="inputName">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputLat" class="col-lg-3 control-label">Latitude</label>
                            <div class="col-lg-9">
                                <input name="latitude" type="text" class="form-control" id="inputLat" disabled>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputLat" class="col-lg-3 control-label">Longitude</label>
                            <div class="col-lg-9">
                                <input name="longitude" type="text" class="form-control" id="inputLong" disabled>
                            </div>
                        </div>
                    </fieldset>
                </form>
                <div class='map-holder'> </div>
            </div>
            <div class="modal-footer">
                <button type="reset" class="btn btn-default" data-dismiss="modal">Hide</button>
                <button type="submit" class="btn btn-primary">Go</button>
            </div>
        </div>
    </div>
</div>