@include('common.header')

{{--Side navigation--}}
<section class="wrapper">

    <div class="filler-wrapper">
        {{--Top nav--}}
        <header>
            @include('nav.admin-top')
        </header>

        <main>

            <div class="page-wrapper">

                <div class="page-content">

                @include('flash::message')

                @yield('content')

                </div>

            </div>

            @include('common.footer')

        </main>
    </div>
</section>