@extends('layouts.homepage')
@section('content')

    <section id="section_header">
        <nav class="nav">
            <a href="{{url('/login')}}" class="btn">Login</a>
            <a href="{{url('/register')}}" class="btn">Sign up</a>
        </nav>
        <div class="table-wrapper container">
            <div class="table-inner">
                <div class="table-center">
                    {{--<img src="{{ FilePath::img('Helpin2.jpg') }}"/>--}}
                    <h1 class="banner_title">Making a difference
                    </h1>
                    <div class="banner_subtitle">One small change at a time</div>
                    <div id="div_userHelpContainer row">
                        <div id="div_HowDoIHelp" class="col-lg-6 col-md-6 col-xs-6 text-center">
                            <a href="#map_section" class="banner-btn">
                                <img src="{{ FilePath::img('Shape 4.png') }}"/>
                                <h3>Show me how I can help.</h3>
                            </a>
                        </div>
                        <div id="div_IKnowHowToHelp" class="col-lg-6 col-md-6 col-xs-6 text-center">
                            <a href="#causes" class="banner-btn">
                                <img src="{{ FilePath::img('Shape 3.png') }}"/>
                                <h3>I know how to help.</h3>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>

    <section id="map_section">
        <div class="map_filters affix-scroll">
            <ul>
                <li>
                    <div class="btn-filter">
                        <input type="checkbox" id="water"/><label for="water" class="btn water">Water</label>
                    </div>
                </li>
                <li>
                    <div class="btn-filter">
                        <input type="checkbox" id="gas"/><label for="gas" class="btn gas">Gas</label>
                    </div>
                </li>
                <li>
                    <div class="btn-filter">
                        <input type="checkbox" id="electricity"/><label for="electricity" class="btn electricity">Electricity</label>
                    </div>
                </li>
                <li>
                    <div class="btn-filter">
                        <input type="checkbox" id="homelessness"/><label for="homelessness" class="btn homelessness">Homelessness</label>
                    </div>
                </li>
            </ul>
        </div>
        <div class="map_bounds">
            <div id="map"></div>
            <div id="map_details">
                <div class="map_details__close-btn">

                </div>
                <div class="map_details__content">

                </div>
            </div>
            <a href="#howToHelp" class="map_help_out"><img src="{{ FilePath::img('down_arrows.png')}}">See how you can help<img src="{{ FilePath::img('down_arrows.png')}}"></a>
        </div>
    </section>

    <section id="howToHelp">
        <h1>How I can help . . .</h1>
        <div id="causes">
            @foreach($types as $type)
            <a href="{{url("/dashboard")}}" class="help-method {{ $type->datatype->name }}">
                <div class="table-wrapper">
                    <div class="table-inner">
                        <div class="table-center">
                            {{ $type->title }}
                        </div>
                    </div>
                </div>
            </a>
            @endforeach
        </div>
    </section>
    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBDwr5jWedGA87GMdvxT2L6WkQ8VXIjqV0&callback=App.MapController.init&libraries=geometry,visualization"
            defer></script>
@endsection