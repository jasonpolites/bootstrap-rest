<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>ShareThis&reg; REST API Template</title>
    <script src="//code.jquery.com/jquery-1.9.1.min.js"></script>
    <script src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.1/js/bootstrap.min.js"></script>
    <link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.1/css/bootstrap-combined.min.css" rel="stylesheet">
    <link href="css/crossdevice.css" rel="stylesheet">

    <link rel="icon" href="images/favicon.ico">

    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]><script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
    <script>
        function runDemo() {
            var txt = $('#txtCookieId');
            var val = txt.val();
            if(val && val!="") {
                doApiCall(val);
            }
            return false;
        }
        function doApiCall(id) {
            var res = $('#dvDemoResults');

            $.ajax({
                type: "POST",
                url: 'api/sample',
                data: 'value=' + id,
                success: function (data, textStatus, jqXHR) {
                    res.html( JSON.stringify(data, null, 4) );
                },
                error: function(jqXHR, textStatus, errorThrown) {
                    res.html(textStatus + ":" + errorThrown);
                },
                complete: function() {
                    res.show()
                }
            });
        }
    </script>
</head>

<body>

<div class="container-narrow">

    <div class="masthead">
        <ul class="nav nav-pills pull-right">
            <li class="active"><a href="/">Home</a></li>
            <li><a href="http://github.com/socialize/bootstrap-rest" target="_blank">Github</a></li>
        </ul>
         <h3 class="muted"><img src="images/sharethis.png" style="vertical-align: text-top"/>&nbsp;ShareThis<sup style="font-size: 11px; font-weight: normal; vertical-align: super">&reg;</sup></h3>
    </div>

    <hr>

    <div class="jumbotron">
        <h1>REST API Template</h1>
        <p class="lead">A simple template REST API application used to bootstrap the creation of RESTful services in Java</p>

        <form class="form-inline" onsubmit="return runDemo();">
            <div class="control-group" id="dvControlGroup">
                <input id="txtCookieId" type="text" class="input" placeholder="Enter a value" required>
                <input type="submit" class="btn btn-success" id="btnRunDemo" value="Run Demo"/>
            </div>
        </form>
    </div>

    <pre id="dvDemoResults" style="display: none"></pre>

    <hr>

    <div class="row-fluid marketing">
        <div class="span6">
            <a href="http://github.com/socialize/bootstrap-rest" target="_blank"><h4>Github Repository</h4></a>
            <p>Download the source code for the Bootstrap REST API</p>
        </div>

        <div class="span6">
            <a href="https://www.sharethis.com" target="_blank"><h4>Other</h4></a>
            <p>Add more links as required</p>
        </div>
    </div>

    <hr>

    <div class="footer">
        <p>&copy; ShareThis 2013</p>
    </div>

</div> <!-- /container -->
</body>
</html>
