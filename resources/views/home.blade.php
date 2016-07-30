@extends('layouts.homepage')
@section('content')

    <section id="section_header">
        <div class="table-wrapper">
            <div class="table-inner">
                <div class="table-center">
                    {{--<img src="{{ FilePath::img('Helpin2.jpg') }}"/>--}}
                    <h1>One World, Many Problems<br/>
                    <small>I love lamp</small></h1>
                    <div id="div_userHelpContainer">
                        <a href="#map_section">
                            <div id="div_HowDoIHelp" class="col-lg-6 col-md-6 col-sm-12 text-center">
                                <img src="{{ FilePath::img('Shape 4.png') }}"/>
                                <h3>Show me how I can help.</h3>
                            </div>
                        </a>
                        <a href="#causes">
                            <div id="div_IKnowHowToHelp" class="col-lg-6 col-md-6 col-sm-12 text-center">
                                <img src="{{ FilePath::img('Shape 3.png') }}"/>
                                <h3>I know how to help.</h3>
                            </div>
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </section>

    <section id="map_section">
        <div class="map_filters affix-scroll">
            <ul>
                <li>
                    <button class="btn water-btn">Water</button>
                </li>
                <li>
                    <button class="btn gas-btn">Gas</button>
                </li>
                <li>
                    <button class="btn electricity-btn">Electricity</button>
                </li>
                <li>
                    <button class="btn homelessness-btn">Homelessness</button>
                </li>
            </ul>
        </div>
        <div class="map_bounds">
            <div id="map"></div>
            <div id="problems" class="draggable"></div>
        </div>
    </section>

    <section id="howToHelp">
        <div id="causes">
            <h1>How I can help . . .</h1>
        </div>
    </section>

    <script>
        var map;
        function initMap() {
            map = new google.maps.Map(document.getElementById('map'), {
                center: {lat: -34.397, lng: 150.644},
                zoom: 4,
                scrollwheel: false,
                mapTypeControl: false
            });
        }
    </script>
    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBDwr5jWedGA87GMdvxT2L6WkQ8VXIjqV0&callback=App.MapController.init"
            async defer></script>
@endsection